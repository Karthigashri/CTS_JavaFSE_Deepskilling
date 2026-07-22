import React from "react";
import BookDetails from "./BookDetails";
import BlogDetails from "./BlogDetails";
import CourseDetails from "./CourseDetails";

function App() {
  return (
    <div style={styles.container}>
      <div style={styles.box}>
        <CourseDetails />
      </div>

      <div style={styles.box}>
        <BookDetails />
      </div>

      <div style={styles.lastBox}>
        <BlogDetails />
      </div>
    </div>
  );
}

const styles = {
  container: {
    display: "flex",
    justifyContent: "space-around",
    alignItems: "stretch",   // Change from flex-start to stretch
    marginTop: "60px",
    padding: "20px"
  },

  box: {
    width: "30%",
    padding: "20px",
    borderRight: "5px solid green",
    minHeight: "420px"       // Give all columns the same height
  },

  lastBox: {
    width: "30%",
    padding: "20px",
    minHeight: "420px"
  }
};
export default App;