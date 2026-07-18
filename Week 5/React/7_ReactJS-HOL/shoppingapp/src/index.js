import React from "react";
import ReactDOM from "react-dom/client";
import App from "./App";
import "./index.css"; // This is how you correctly import CSS into JavaScript

const root = ReactDOM.createRoot(document.getElementById("root"));
root.render(
  <React.StrictMode>
    <App />
  </React.StrictMode>
);