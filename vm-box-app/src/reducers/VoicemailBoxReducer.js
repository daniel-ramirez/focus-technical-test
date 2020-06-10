import {
  FETCHING_VOICEMAILBOXES,
  FETCHED_VOICEMAILBOXES,
  FETCHING_VOICEMAILMESSAGES,
  FETCHED_VOICEMAILMESSAGES
} from "../actions/actionTypes";
  
export const initialState = {
  voicemailBox: {},
  voicemailBoxList: [],
  voicemailMessageList: []
};

export default (state = initialState, action) => {
  switch (action.type) {
    case FETCHING_VOICEMAILBOXES:
      return state;

    case FETCHED_VOICEMAILBOXES:
      return {
        ...state,
        voicemailBox: action.payload.content
      };

    case FETCHING_VOICEMAILMESSAGES:
      return {
        ...state
      }

    case FETCHED_VOICEMAILMESSAGES:
      return {
        ...state,
        voicemailMessageList: action.payload.content
      };

    default:
      return state;
  }
};
  