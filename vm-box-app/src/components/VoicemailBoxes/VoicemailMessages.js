import React, { Component } from "react";
import PropTypes from "prop-types";
import { connect } from "react-redux";
import { Link } from "react-router-dom"
import Paper from '@material-ui/core/Paper';
import Table from '@material-ui/core/Table';
import TableBody from '@material-ui/core/TableBody';
import TableCell from '@material-ui/core/TableCell';
import TableContainer from '@material-ui/core/TableContainer';
import TableHead from '@material-ui/core/TableHead';
import TablePagination from '@material-ui/core/TablePagination';
import TableRow from '@material-ui/core/TableRow';
import Button from '@material-ui/core/Button';
import { fetchDefaultVoicemailBoxes, fetchDefaultVoicemailMessages } from "../../actions/VoicemailBoxActions";

class VoicemailMessages extends Component {
  constructor(props) {
    super(props);
    this.state = {
      page: 0,
      rowsPerPage: 20
    };
  }
  
  componentDidMount() {
    // Load VoicemailBoxes
    this.props.fetchDefaultVoicemailBoxes();
    // Load VoicemailMessages
    this.props.fetchDefaultVoicemailMessages();
  }

  render() {
    const columns = [
      { id: 'folder', label: 'Status', minWidth: 200 },
      { id: 'from', label: 'From', minWidth: 150 },
      { id: 'to', label: 'To', minWidth: 150 },
      { id: 'length', label: 'Duration', minWidth: 150 },
    ];

    const handleChangePage = (event, newPage) => {
      this.state.page = newPage;
    };

    const handleChangeRowsPerPage = (event) => {
      this.state.rowsPerPage = +event.target.value;
      this.state.page = 0;
    };

    // Return main content
    return (
      <div style={{ flexGrow: 1 }}>
        <Paper>
          <TableContainer>
            <Table stickyHeader aria-label="sticky table">
              <TableHead>
                <TableRow>
                  {columns.map((column) => (
                    <TableCell
                      key={column.id}
                      align={column.align}
                      style={{ minWidth: column.minWidth }}
                    >
                      {column.label}
                    </TableCell>
                  ))}
                </TableRow>
              </TableHead>
              <TableBody>
                {this.props.voicemailMessageList.slice(this.state.page * this.state.rowsPerPage, this.state.page * this.state.rowsPerPage + this.state.rowsPerPage).map((row) => {
                  return (
                    <TableRow hover role="checkbox" tabIndex={-1} key={row.media_id}>
                      {columns.map((column) => {
                        const value = row[column.id];
                        return (
                          <TableCell key={column.id} align={column.align}>
                            {column.format && typeof value === 'number' ? column.format(value) : value}
                          </TableCell>
                        );
                      })}
                    </TableRow>
                  );
                })}
              </TableBody>
            </Table>
          </TableContainer>
          <TablePagination
            rowsPerPageOptions={[10, 20, 50, 100]}
            component="div"
            count={this.props.voicemailMessageList.length}
            rowsPerPage={this.state.rowsPerPage}
            page={this.state.page}
            onChangePage={handleChangePage}
            onChangeRowsPerPage={handleChangeRowsPerPage}
          />
          <Button
            component={Link}
            to="/"
            variant="contained"
            color="primary"
            size="small"
          >
            Close
          </Button>
        </Paper>
      </div>
    );
  }
}

VoicemailMessages.propTypes = {
  voicemailBox: PropTypes.object.isRequired,
  voicemailMessageList: PropTypes.array.isRequired,
  fetchDefaultVoicemailBoxes: PropTypes.func.isRequired,
  fetchDefaultVoicemailMessages: PropTypes.func.isRequired
};

const mapStateToProps = state => ({
  voicemailBox: state.voicemailBoxes.voicemailBox,
  voicemailMessageList: state.voicemailBoxes.voicemailMessageList,
  fetchDefaultVoicemailBoxes: state.fetchDefaultVoicemailBoxes,
  fetchDefaultVoicemailMessages: state.fetchDefaultVoicemailMessages,
  isLoading: state.ui.isLoading
});

export default connect(
  mapStateToProps,
  { fetchDefaultVoicemailBoxes, fetchDefaultVoicemailMessages }
)(VoicemailMessages);