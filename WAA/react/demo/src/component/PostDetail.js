import React from "react";
import axios from "axios";
import Comment from "./Comment";

const PostDetail = ({ post, onDelete }) => {
  const handleDelete = async () => {
    try {
      await axios.delete(`http://localhost:8080/api/v1/posts/${post.id}`);
      onDelete(); // Call the onDelete function to update the fetched posts
    } catch (error) {
      console.error("Error deleting post:", error);
    }
  };

  return (
    <div>
      <h3>Title: {post.title}</h3>
      <p>Content: {post.content}</p>
      <p>Author: {post.author}</p>
      <h4>Comment</h4>
      {post.comments.map((comment) => (
        <Comment key={comment.id} comment={comment} />
      ))}
      <button onClick={handleDelete}>Delete</button>
    </div>
  );
};

export default PostDetail;
