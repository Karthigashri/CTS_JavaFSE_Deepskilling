import React, { Component } from "react";

const validEmailRegex =
  /^[^\s@]+@[^\s@]+\.[^\s@]+$/;

const validateForm = (errors) => {
  let valid = true;

  Object.values(errors).forEach((val) => {
    if (val.length > 0) {
      valid = false;
    }
  });

  return valid;
};

class Register extends Component {
  constructor(props) {
    super(props);

    this.state = {
      fullName: "",
      email: "",
      password: "",
      errors: {
        fullName: "",
        email: "",
        password: ""
      }
    };
  }

  handleChange = (event) => {
    const { name, value } = event.target;

    let errors = this.state.errors;

    switch (name) {
      case "fullName":
        errors.fullName =
          value.length < 5 ? "Full Name must be 5 characters long!"
            : "";
        break;

      case "email":
        errors.email =
          validEmailRegex.test(value)
            ? ""
            : "Email is not valid!";
        break;

      case "password":
        errors.password =
          value.length < 8
            ? "Password must be 8 characters long!"
            : "";
        break;

      default:
        break;
    }

    this.setState({
      errors,
      [name]: value
    });
  };

  handleSubmit = (event) => {
    event.preventDefault();

    if (validateForm(this.state.errors)) {
      alert("Valid Form");
    } else {
      if (this.state.errors.fullName !== "")
        alert(this.state.errors.fullName);

      else if (this.state.errors.email !== "")
        alert(this.state.errors.email);

      else if (this.state.errors.password !== "")
        alert(this.state.errors.password);
    }
  };

  render() {
    return (
      <div
        style={{
          marginTop: "250px",
          marginRight:"800px",
          textAlign: "center"
        }}
      >
        <h1 style={{ color: "red",fontSize:"40px"}}>
          Register Here!!!
        </h1>

        <form onSubmit={this.handleSubmit}>
          <table 
            style={{
              margin: "auto",
            }}
            cellPadding="10px"
          >
            <tbody >
              <tr >
                <td style={{fontSize:"30px"}}>Name:</td>

                <td>
                  <input
                    type="text"
                    name="fullName"
                    value={this.state.fullName}
                    onChange={this.handleChange}
                    style={{fontSize:"30px"}}
                  />
                </td>

              </tr>

              <tr>
                <td style={{fontSize:"30px"}}>Email:</td>

                <td>
                  <input
                    type="text"
                    name="email"
                    value={this.state.email}
                    onChange={this.handleChange}
                    style={{fontSize:"30px"}}

                  />
                </td>
              </tr>

              <tr>
                <td  style={{fontSize:"30px"}}>Password:</td>

                <td>
                  <input
                    type="password"
                    name="password"
                    value={this.state.password}
                    onChange={this.handleChange}
                    style={{fontSize:"30px"}}

                  />
                </td>
              </tr>

              <tr>
                <td></td>

                <td>
                  <button type="submit"  style={{fontSize:"30px"}}>
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

export default Register;