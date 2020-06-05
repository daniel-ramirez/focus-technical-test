import React, { Component } from "react";
import PropTypes from "prop-types";
import { connect } from "react-redux";
import Typography from '@material-ui/core/Typography';
import Container from '@material-ui/core/Container';
import Grid from '@material-ui/core/Grid';
import Paper from '@material-ui/core/Paper';
import Button from '@material-ui/core/Button';
import { fetchDefaultVoicemailBoxes } from "../../actions/VoicemailBoxActions";

class VoicemailBoxes extends Component {

  render() {
    // Return main content
    return (
      <Container>
          <div style={{ flexGrow: 1 }}>
            <Paper style={{ padding: '3vh', margin: 'auto', maxWidth: '100vh' }}>
              <Grid container spacing={2}>
                <Grid item xs={12} sm container>
                  <Grid item xs container direction="column" spacing={2}>
                    <Grid item xs>
                      <Typography gutterBottom variant="subtitle1">
                        Default Voicemail Boxes
                        </Typography>
                      <Typography variant="body2" color="textSecondary">
                        Client Id: 4642e64040cdb8b89c310a21a07c7f62
                        </Typography>
                      <Typography variant="body2" color="textSecondary">
                        Voicemail Box Id: b37675a2d7b90d60f0ee5d4175502394
                        </Typography>
                    </Grid>
                    <Grid item>
                      <Button variant="contained" color="primary" size="small" onClick={this.props.fetchDefaultVoicemailBoxes}>
                        Open
                        </Button>
                    </Grid>
                  </Grid>
                </Grid>
              </Grid>
            </Paper>
          </div>
      </Container>
    );
  }
}

VoicemailBoxes.propTypes = {
  fetchDefaultVoicemailBoxes: PropTypes.func.isRequired
};

const mapStateToProps = state => ({
  fetchDefaultVoicemailBoxes: state.fetchDefaultVoicemailBoxes,
  isLoading: state.ui.isLoading
});

export default connect(
  mapStateToProps,
  { fetchDefaultVoicemailBoxes }
)(VoicemailBoxes);