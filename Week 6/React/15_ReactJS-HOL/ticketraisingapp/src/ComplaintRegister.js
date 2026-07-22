import React, { Component } from "react";

class ComplaintRegister extends Component {
  constructor(props) {
    super(props);

    this.state = {
      ename: "",
      complaint: "",
      NumberHolder: Math.floor(Math.random() * 100) + 1
    };
  }

  handleChange = (event) => {
    this.setState({
      [event.target.name]: event.target.value
    });
  };

  handleSubmit = (event) => {
    event.preventDefault();

    const msg =
      "Thanks " +
      this.state.ename +
      "\nYour Complaint was Submitted.\nTransaction ID is: " +
      this.state.NumberHolder;

    alert(msg);
  };

  render() {
    return (
      <div style={{ textAlign: "center", marginTop: "300px" }}>
        <h1 style={{ fontSize:"40px",color: "red" }}>
          Register your complaints here!!!
        </h1>

        <form onSubmit={this.handleSubmit}>
          <table
            style={{

              margin: "auto",
              borderSpacing: "10px"
            }}
          >
            <tbody>
              <tr>
                <td style={{fontSize:"30px"}}>Name:</td>

                <td>
                  <input
                    type="text"
                    name="ename"
                    value={this.state.ename}
                    onChange={this.handleChange}
                    style={{fontSize:"30px"}}
                  />
                </td>
              </tr>

              <tr>
                <td style={{fontSize:"30px"}}>Complaint:</td>

                <td>
                  <textarea
                    name="complaint"
                    rows="3"
                    cols="20"
                    value={this.state.complaint}
                    onChange={this.handleChange}
                    style={{fontSize:"30px"}}

                  ></textarea>
                </td>
              </tr>

              <tr>
                <td></td>

                <td>
                  <button type="submit" style={{fontSize:"25px"}}>
                    Submit
                  </button>
                </td>
              </tr>
            </tbody>
          </table>
        </form>
      </div>
    );
  }
}

export default ComplaintRegister;