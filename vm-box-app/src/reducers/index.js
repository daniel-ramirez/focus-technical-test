import { combineReducers } from "redux";
import { reducer as formReducer } from "redux-form";
import uiReducer from "./uiReducer";
import VoicemailBoxReducer from "./VoicemailBoxReducer";

export default combineReducers({
    ui: uiReducer,
    form: formReducer,
    voicemailBoxes: VoicemailBoxReducer
});