import React, { Component } from "react";

// Login Button
function LoginButton(props) {
  return (
    <button onClick={props.onClick}>
      Login
    </button>
  );
}


function LogoutButton(props) {
  return (
    <button onClick={props.onClick}>
      Logout
    </button>
  );
}

function GuestGreeting() {
  return (
    <div>
      <h2>Please sign up.</h2>
      <h3>Flight Details</h3>
      <table style={{ border: "1px solid black", borderCollapse: "collapse", textAlign: "center", width: "200px", padding: "20px" }}>
        <thead>
          <tr>
            <th style={{ border: "1px solid black", padding: "8px", backgroundColor: "lightblue" }}>
              Flight</th>
            <th style={{ border: "1px solid black", padding: "8px", backgroundColor: "lightblue" }}>
              From</th>
            <th style={{ border: "1px solid black", padding: "8px", backgroundColor: "lightblue" }}>
              To</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td style={{ border: "1px solid black", padding: "8px" }}> AI101</td>
            <td style={{ border: "1px solid black", padding: "8px" }}>Chennai</td>
            <td style={{ border: "1px solid black", padding: "8px" }}>Delhi</td>
          </tr>
          <tr>
            <td style={{ border: "1px solid black", padding: "8px" }}>AI202</td>
            <td style={{ border: "1px solid black", padding: "8px" }}>Mumbai</td>
            <td style={{ border: "1px solid black", padding: "8px" }}>Bangalore</td>
          </tr>
        </tbody>
      </table>
    </div>
  );
}

// User Page
function UserGreeting() {
  return (
    <div>
      <h2>Welcome back</h2>

      <h3>You can now book your tickets.</h3>

      <button>Book Ticket</button>
    </div>
  );
}

// Greeting Component
function Greeting(props) {

  const isLoggedIn = props.isLoggedIn;

  if (isLoggedIn) {
    return <UserGreeting />;
  }

  return <GuestGreeting />;
}

// Main Component
class App extends Component {

  constructor(props) {
    super(props);

    this.state = {
      isLoggedIn: false
    };
  }

  loginClick = () => {
    this.setState({
      isLoggedIn: true
    });
  };

  logoutClick = () => {
    this.setState({
      isLoggedIn: false
    });
  };

  render() {

    const isLoggedIn = this.state.isLoggedIn;

    let button;

    if (isLoggedIn) {
      button = (
        <LogoutButton onClick={this.logoutClick} />
      );
    } else {
      button = (
        <LoginButton onClick={this.loginClick} />
      );
    }

    return (
      <div style={{ margin: "20px" }}>

        <Greeting isLoggedIn={isLoggedIn} />

        <br />

        {button}

      </div>
    );
  }
}

export default App;