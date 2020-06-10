import React, { Component } from "react";
import { BrowserRouter, Switch, Route } from "react-router-dom";
import { VoicemailBoxes, VoicemailMessages } from "./VoicemailBoxes";
import Container from '@material-ui/core/Container';

class Main extends Component {
  render() {
    return (
      <Container>
        <BrowserRouter>
          <Switch>
            <Route exact path="/" component={VoicemailBoxes} />
            <Route exact path="/messages" component={VoicemailMessages} />
          </Switch>
        </BrowserRouter>
      </Container>
    );
  }
}

export default Main;