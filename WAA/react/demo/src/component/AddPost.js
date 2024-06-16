import React, { useEffect, useState } from "react";
import axios from "axios";

const AddPost = () => {
  const [title, setTitle] = useState("");
  const [author, setAuthor] = useState("");
  const [content, setContent] = useState("");

  const token =
    "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzIiwiZXhwIjoxNjg2ODQ2Mzg4LCJpYXQiOjE2ODY4NDUzMDh9.Fd6Pv2Ffu-CfHVsYiAcbUSta_NlDPO90Cj5d3vhjSRCFxybz6ELf7TdyE_iiZ4ab_Q2K0GbvwGePlvEcvytdQQ";

  const handleSubmit = async (e) => {
    e.preventDefault();

    try {
      const response = await axios.post(
        "http://localhost:8080/api/v1/posts",
        {
          title,
          author,
          content,
        },
        {
          headers: {
            Authorization: `Bearer ${token}`,
          },
        }
      );

      console.log("Post added:", response.data);

      // Clear the form inputs
      setTitle("");
      setAuthor("");
      setContent("");
    } catch (error) {
      console.error("Error adding post:", error);
    }
  };

  return (
    <div className="addedPosts">
      <form onSubmit={handleSubmit}>
        <div>
          <label>Title:</label>
          <input
            type="text"
            value={title}
            onChange={(e) => setTitle(e.target.value)}
            required
          />
        </div>
        <div>
          <label>Author:</label>
          <input
            type="text"
            value={author}
            onChange={(e) => setAuthor(e.target.value)}
            required
          />
        </div>
        <div>
          <label>Content:</label>
          <textarea
            value={content}
            onChange={(e) => setContent(e.target.value)}
            required
          />
        </div>
        <button type="submit">Add</button>
      </form>
    </div>
  );
};

export default AddPost;
