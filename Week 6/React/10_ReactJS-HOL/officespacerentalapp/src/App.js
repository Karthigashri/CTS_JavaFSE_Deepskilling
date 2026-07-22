import React from "react";

function App() {

  // Office Object
  const office = {
    Name: "DBS",
    Rent: 55000,
    Address: "Chennai"
  };

  // List of Office Spaces
  const officeList = [
    {
      Name: "DBS",
      Rent: 55000,
      Address: "Chennai"
    },
    {
      Name: "WeWork",
      Rent: 75000,
      Address: "Bangalore"
    },
    {
      Name: "SmartWorks",
      Rent: 45000,
      Address: "Hyderabad"
    }
  ];

  return (
    <div style={{ marginLeft: "20px" }}>
      <h1>Office Space Rental App</h1>

      {/* Office Image */}
      <img
        src="/office.jpg"
        alt="Office Space"
        width="25%"
        height="25%"
      />

      <h2>Single Office Details</h2>

      <p><b>Name:</b> {office.Name}</p>

      <p>
        <b>Rent:</b>{" "}
        <span
          style={{
            color: office.Rent < 60000 ? "red" : "green",
            fontWeight: "bold"
          }}
        >
          Rs. {office.Rent}
        </span>
      </p>

      <p><b>Address:</b> {office.Address}</p>

      <hr />

      <h2>Office Space List</h2>

      {officeList.map((item, index) => (
        <div key={index} style={{ marginBottom: "20px" }}>

          <p><b>Name:</b> {item.Name}</p>

          <p>
            <b>Rent:</b>{" "}
            <span
              style={{
                color: item.Rent < 60000 ? "red" : "green",
                fontWeight: "bold"
              }}
            >
              Rs. {item.Rent}
            </span>
          </p>

          <p><b>Address:</b> {item.Address}</p>

          <hr />

        </div>
      ))}

    </div>
  );
}

export default App;