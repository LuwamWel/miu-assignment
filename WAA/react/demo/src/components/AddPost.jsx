// AddPost.js
import React, { useState } from "react";
import axios from "axios";

const AddPost = ({ fetchPosts }) => {
  const [title, setTitle] = useState("");
  const [author, setAuthor] = useState("");
  const [content, setContent] = useState("");

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      await axios.post('http://localhost:8080/api/posts', {
        title,
        author,
        content,
      });
      setTitle("");
      setAuthor("");
      setContent("");
      fetchPosts();  // Refresh the posts after adding a new one
    } catch (error) {
      console.error("Error adding post:", error);
    }
  };

  return (
    <form onSubmit={handleSubmit} style={{ display: "flex", flexDirection: "column", width: "300px" }}>
      <input
        type="text"
        value={title}
        onChange={(e) => setTitle(e.target.value)}
        placeholder="Title"
        required
        style={{ marginBottom: "10px", padding: "10px", borderRadius: "5px", border: "1px solid #ccc" }}
      />
      <input
        type="text"
        value={author}
        onChange={(e) => setAuthor(e.target.value)}
        placeholder="Author"
        required
        style={{ marginBottom: "10px", padding: "10px", borderRadius: "5px", border: "1px solid #ccc" }}
      />
      <textarea
        value={content}
        onChange={(e) => setContent(e.target.value)}
        placeholder="Content"
        required
        style={{ marginBottom: "10px", padding: "10px", borderRadius: "5px", border: "1px solid #ccc" }}
      />
      <button type="submit" style={{ padding: "10px 15px", borderRadius: "5px", border: "none", background: "#007bff", color: "white", cursor: "pointer" }}>Add Post</button>
    </form>
  );
};

export default AddPost;
