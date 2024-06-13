// PostDetails.js
import React, { useEffect, useState } from "react";
import axios from "axios";

const PostDetails = ({ postId, onDelete }) => {
  const [post, setPost] = useState(null);

  useEffect(() => {
    fetchPost();
  }, [postId]);

  const fetchPost = async () => {
    try {
      const response = await axios.get(`http://localhost:8080/api/posts/${postId}`);
      setPost(response.data);
    } catch (error) {
      console.error("Error fetching post:", error);
    }
  };

  const handleDelete = async () => {
    try {
      await axios.delete(`http://localhost:8080/api/posts/${postId}`);
      onDelete(postId);
    } catch (error) {
      console.error("Error deleting post:", error);
    }
  };

  if (!post) return <div>Loading...</div>;

  return (
    <div style={{ border: "1px solid black", padding: "20px", borderRadius: "5px", margin: "20px auto", maxWidth: "600px" }}>
      <h2>{post.title}</h2>
      <p><strong>Author:</strong> {post.author}</p>
      <p>{post.content}</p>
      <button onClick={handleDelete} style={{ padding: "10px 15px", borderRadius: "5px", border: "none", background: "#dc3545", color: "white", cursor: "pointer" }}>Delete Post</button>
    </div>
  );
};

export default PostDetails;
