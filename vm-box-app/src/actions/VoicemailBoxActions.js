import { apiRequest } from "../api";
import { showSpinner, hideSpinner } from "./uiActions";
import { FETCH_VOICEMAILBOXES } from "./actionTypes";

const accountId = "4642e64040cdb8b89c310a21a07c7f62";
const vmBoxId = "b37675a2d7b90d60f0ee5d4175502394";

export const fetchDefaultVoicemailBoxes = () => dispatch => {
  // Dispatch action to show spinner
  dispatch(showSpinner());

  const meta = {
    endpoint: `/accounts/${accountId}/vmboxes/${vmBoxId}/messages`,
    method: "get",
    onSuccessAction: FETCH_VOICEMAILBOXES,
    onCompleteAction: hideSpinner
  };

  dispatch(apiRequest(null, null, meta));
};

export const fetchVoicemailBoxes = (accountId, vmBoxId) => dispatch => {
  // Dispatch action to show spinner
  dispatch(showSpinner());

  const meta = {
    endpoint: `/accounts/${accountId}/vmboxes/${vmBoxId}/messages`,
    method: "get",
    onSuccessAction: FETCH_VOICEMAILBOXES,
    onCompleteAction: hideSpinner
  };

  dispatch(apiRequest(null, null, meta));
};
