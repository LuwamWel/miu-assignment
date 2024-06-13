// Post.js
import React from "react";

export const Post = (props) => {
  const customStyle = {
    border: "1px solid black",
    width: "200px",
    textAlign: "center",
    backgroundColor: "blue",
    color: "white",
    opacity: "0.8",
    margin: "10px",
    padding: "10px",
    borderRadius: "5px",
    cursor: "pointer",
  };

  return (
    <div style={customStyle}>
      <p>Id: {props.id}</p>
      <p>Title: {props.title}</p>
      <p>Author: {props.author}</p>
    </div>
  );
};
