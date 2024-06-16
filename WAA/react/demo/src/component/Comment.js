import React from "react";

const Comment = ({ Comment }) => {
  return (
    <div>
      <p>{Comment.name}</p>
      <p>{Comment.content}</p>
    </div>
  );
};

export default Comment;
