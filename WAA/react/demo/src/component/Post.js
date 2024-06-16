import React from "react";

const Post = ({ title, content, author }) => (
  <div className="post-box">
    <h2>{title}</h2>
    <p>{content}</p>
    <p>{author}</p>
  </div>
);

export default Post;
