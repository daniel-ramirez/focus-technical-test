import axios from "axios";

const BACKEND_URL = "http://localhost:8080/v2";
const authToken = "Basic eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTU5MzUzOTQ3M30._9VcOD1BHk0lr9kmwRpkMeHOkhSpuGw03NWH1-zCu5cesj7cUNVPgOgWPQhZUujKGbLnDhpjn13-otWtEH6kHQ";

// Request interceptor
axios.interceptors.request.use(
  function(config) {

    return config;
  },
  function(error) {
    // Do something with request error
    return Promise.reject(error);
  }
);

// Add a response interceptor
axios.interceptors.response.use(
  function(response) {
    return response;
  },
  function(error) {
    // Any status codes that falls outside the range of 2xx cause this function to trigger
    // Do something with response error
    return Promise.reject(error);
  }
);

export const apiRequest = (requestData, routerHistory, meta) => dispatch => {
  // Mapping request parameters
  const reqConfig = {
    url: meta.endpoint,
    method: meta.method,
    baseURL: BACKEND_URL,
    data: requestData,
    headers: {
      Authorization: authToken
    }
  };
  // setTimeout(() => {
  // Making request to API server
  axios
    .request(reqConfig)
    .then(response => {
      // Dispatch action after successful API call
      dispatch({
        type: meta.onSuccessAction,
        payload: response.data
      });

      // TODO: Think about how to decouple the dispatch of actions from the API call function
      // Dispatch action to hide spinner
      meta.onCompleteAction &&
        ((typeof meta.onCompleteAction === "function" &&
          dispatch(meta.onCompleteAction())) ||
          dispatch({ type: meta.onCompleteAction }));

      // Redirect to route if provided by the action creator
      meta.redirectRoute && routerHistory.push(meta.redirectRoute);
    })
    .catch(error => {
      if (error.response) {
        // The request was made and the server responded with a status code
        // that falls out of the range of 2xx
        console.error(error.response.data);
        console.error(error.response.status);
        console.error(error.response.headers);
      } else if (error.request) {
        // The request was made but no response was received
        // `error.request` is an instance of XMLHttpRequest in the browser and an instance of
        // http.ClientRequest in node.js
        console.error(error.request);
      } else {
        // Something happened in setting up the request that triggered an Error
        console.error("Error", error.message);
      }
      console.trace(error.config);
    });
  // }, 3000);
};

/**
 *  API call with next actions
 *  - success
 *  - failure
 */
export const apiWithNextActions = ({
  requestData,
  meta,
  nextActions,
  nextActionData
}) => dispatch => {
  // Mapping request parameters
  const requestConfig = {
    url: meta.endpoint,
    method: meta.method,
    baseURL: BACKEND_URL,
    data: requestData,
    headers: {
      Authorization: authToken
    }
  };

  axios
    .request(requestConfig)
    .then(response =>
      dispatch(
        nextActions.onSuccess({
          response,
          callbackInfo: requestData,
          nextActionData
        })
      )
    )
    .catch(error => {
      // handle error logic
      console.error("API error:", JSON.stringify(error, null, 4));
      dispatch(nextActions.onFailure({ error }));
    });
};

/**
 *  API to be called from components,
 *  it will return a promise to be used from components
 *  so the logic should be handled inside components instead!
 */
export const apiFromComponents = ({ requestData }) => {
  const requestConfig = {
    ...requestData,
    baseURL: BACKEND_URL,
    headers: {
      Authorization: authToken
    }
  };

  return axios
    .request(requestConfig)
    .then(response => response)
    .catch(err => {
      throw err;
    });
};

/**
 * request config with headers
 * it should allow us to have one central requestConfig object that holds
 * common logic, such as headers, baseURL, etc
 */
export const requestConfigWithHeaders = () => {
  const requestConfig = {
    baseURL: BACKEND_URL,
    headers: {
      Authorization: authToken
    }
  };

  return requestConfig;
};
