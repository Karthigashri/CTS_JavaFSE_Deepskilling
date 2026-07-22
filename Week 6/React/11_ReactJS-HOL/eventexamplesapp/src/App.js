import React, { Component } from "react";
import CurrencyConvertor from "./CurrencyConvertor";

class App extends Component {

  constructor() {
    super();

    this.state = {
      count: 0
    };
  }

  // Increment Counter
  increment = () => {
    this.setState({
      count: this.state.count + 1
    });
  };

  // Decrement Counter
  decrement = () => {
    this.setState({
      count: this.state.count - 1
    });
  };

  // Say Hello
  sayHello = () => {
    alert("Hello! Member1");
  };

  // Welcome Function
  sayWelcome = (msg) => {
    alert(msg);
  };

  // Synthetic Event
  onPress = () => {
    alert("I was clicked");
  };

  render() {
    return (
      <div style={{ margin: "20px" }}>

        <h2>{this.state.count}</h2>

        {/* Multiple Methods */}
        <button
          onClick={() => {
            this.increment();
            this.sayHello();
          }}
        >
          Increment
        </button>

        <br /><br />

        <button onClick={this.decrement}>
          Decrement
        </button>

        <br /><br />

        <button onClick={() => this.sayWelcome("welcome")}>
          Say welcome
        </button>

        <br /><br />

        <button onClick={this.onPress}>
          Click on me
        </button>

        <hr />

        <CurrencyConvertor />

      </div>
    );
  }
}

export default App;