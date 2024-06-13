// Posts.js
import React from "react";
import { Post } from "./Post";

export const Posts = (props) => {
  return (
    <div onClick={() => props.onPostSelect(props.id)} style={{ cursor: "pointer" }}>
      <Post id={props.id} title={props.title} author={props.author} />
    </div>
  );
};
