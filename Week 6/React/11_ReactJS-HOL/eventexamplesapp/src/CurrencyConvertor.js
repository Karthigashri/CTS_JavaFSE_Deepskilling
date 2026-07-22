import React, { Component } from "react";

class CurrencyConvertor extends Component {

    constructor() {
        super();

        this.state = {
            amount: "",
            currency: ""
        };
    }

    handleAmount = (event) => {
        this.setState({
            amount: event.target.value
        });
    };

    handleCurrency = (event) => {
        this.setState({
            currency: event.target.value
        });
    };

    handleSubmit = () => {

        // Euro to Rupees Conversion
        let result = this.state.amount * 80;

        alert(
            "Converting to " +
            this.state.currency +
            "\nAmount is " +
            result
        );
    };

    render() {

        return (

            <div>

                <h1 style={{ color: "green" }}>
                    Currency Convertor!!!
                </h1>

                <table>

                    <tbody>

                        <tr>

                            <td>Amount:</td>

                            <td>

                                <input
                                    type="number"
                                    value={this.state.amount}
                                    onChange={this.handleAmount}
                                />

                            </td>

                        </tr>

                        <tr>

                            <td>Currency:</td>

                            <td>

                                <textarea
                                    value={this.state.currency}
                                    onChange={this.handleCurrency}
                                />

                            </td>

                        </tr>

                        <tr>

                            <td></td>

                            <td>

                                <button onClick={this.handleSubmit}>
                                    Submit
                                </button>

                            </td>

                        </tr>

                    </tbody>

                </table>

            </div>

        );
    }
}

export default CurrencyConvertor;