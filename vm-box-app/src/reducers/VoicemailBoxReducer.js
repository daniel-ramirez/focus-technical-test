import { FETCH_VOICEMAILBOXES } from "../actions/actionTypes";
  
  const initialState = {
    VoicemailMessageList: []
  };
  
  export default (state = initialState, action) => {
    switch (action.type) {
      case FETCH_VOICEMAILBOXES:
        return {
          ...state,
          VoicemailMessageList: action.payload.data
        };
  
      default:
        return state;
    }
  };
  