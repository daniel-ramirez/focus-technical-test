import { apiRequest } from "../api";
import { showSpinner, hideSpinner } from "./uiActions";
import {
  FETCHING_VOICEMAILBOXES,
  FETCHED_VOICEMAILBOXES,
  FETCHING_VOICEMAILMESSAGES,
  FETCHED_VOICEMAILMESSAGES
} from "./actionTypes";

const accountId = "4642e64040cdb8b89c310a21a07c7f62";
const vmBoxId = "b37675a2d7b90d60f0ee5d4175502394";

export const fetchDefaultVoicemailBoxes = () => dispatch => {
  // Dispatch action to show spinner
  dispatch(showSpinner());

  // Reset the current object
  dispatch({ type: FETCHING_VOICEMAILBOXES });

  const meta = {
    endpoint: `/accounts/${accountId}/vmboxes/${vmBoxId}`,
    method: "get",
    onSuccessAction: FETCHED_VOICEMAILBOXES,
    onCompleteAction: hideSpinner
  };

  dispatch(apiRequest(null, null, meta));
};

export const fetchVoicemailBoxes = (accountId, vmBoxId) => dispatch => {
  // Dispatch action to show spinner
  dispatch(showSpinner());

  // Reset the current object
  dispatch({ type: FETCHING_VOICEMAILBOXES });

  const meta = {
    endpoint: `/accounts/${accountId}/vmboxes/${vmBoxId}`,
    method: "get",
    onSuccessAction: FETCHED_VOICEMAILBOXES,
    onCompleteAction: hideSpinner
  };

  dispatch(apiRequest(null, null, meta));
};

export const fetchDefaultVoicemailMessages = () => dispatch => {
  // Dispatch action to show spinner
  dispatch(showSpinner());

  // Reset the current object
  dispatch({ type: FETCHING_VOICEMAILMESSAGES });

  const meta = {
    endpoint: `/accounts/${accountId}/vmboxes/${vmBoxId}/messages`,
    method: "get",
    onSuccessAction: FETCHED_VOICEMAILMESSAGES,
    onCompleteAction: hideSpinner
  };

  dispatch(apiRequest(null, null, meta));
};

export const fetchVoicemailMessages = (accountId, vmBoxId) => dispatch => {
  // Dispatch action to show spinner
  dispatch(showSpinner());

  // Reset the current object
  dispatch({ type: FETCHING_VOICEMAILMESSAGES });

  const meta = {
    endpoint: `/accounts/${accountId}/vmboxes/${vmBoxId}/messages`,
    method: "get",
    onSuccessAction: FETCHED_VOICEMAILMESSAGES,
    onCompleteAction: hideSpinner
  };

  dispatch(apiRequest(null, null, meta));
};
