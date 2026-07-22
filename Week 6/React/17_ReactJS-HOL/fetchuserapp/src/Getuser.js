import React, { Component } from "react";

class Getuser extends Component {
  constructor(props) {
    super(props);

    this.state = {
      person: {},
      loading: true
    };
  }

  async componentDidMount() {
    const url = "https://api.randomuser.me/";

    const response = await fetch(url);

    const data = await response.json();

    this.setState({
      person: data.results[0],
      loading: false
    });

    console.log(data.results[0]);
  }

  render() {
    if (this.state.loading) {
      return <h2>Loading...</h2>;
    }

    const { title, first } = this.state.person.name;
    const picture = this.state.person.picture.large;

    return (
      <div
        style={{
          marginLeft: "180px",
          marginTop: "100px"
        }}
      >
        <h1>
          {title} {first}
        </h1>

        <img
          src={picture}
          alt="User"
          width="150"
          height="150"
        />
      </div>
    );
  }
}

export default Getuser;