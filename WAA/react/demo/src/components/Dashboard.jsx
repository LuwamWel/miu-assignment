// Dashboard.js
import React, { useState, useEffect } from "react";
import axios from "axios";
import { Posts } from "./Posts";
import AddPost from "./AddPost";

export const Dashboard = ({ onPostSelect }) => {
  const customStyle = {
    display: "flex",
    justifyContent: "center",
    marginTop: "20px",
  };

  const customStyleHeader = {
    textAlign: "center",
    fontFamily: "monospace",
    fontSize: "2em",
    marginBottom: "20px"
  };

  const [postInfo, setPostInfo] = useState([]);
  const [inputValue, setInputValue] = useState("");

  useEffect(() => {
    fetchPosts();
  }, []);

  const fetchPosts = async () => {
    try {
      const response = await axios.get('http://localhost:8080/api/posts');
      setPostInfo(response.data);
    } catch (error) {
      console.error("Error fetching posts:", error);
    }
  };

  const handleChange = (e) => {
    setInputValue(e.target.value);
  };

  const changeNameHandler = () => {
    const updatedPostInfo = [...postInfo];
    updatedPostInfo[0].title = inputValue;
    setPostInfo(updatedPostInfo);
  };

  return (
    <div>
      <h1 style={customStyleHeader}>Dashboard</h1>
      <div style={customStyle}>
        <input
          value={inputValue}
          onChange={handleChange}
          style={{ marginRight: "1vw", padding: "10px", borderRadius: "5px", border: "1px solid #ccc" }}
          type="text"
          placeholder="New title"
        />
        <button onClick={changeNameHandler} style={{ padding: "10px 15px", borderRadius: "5px", border: "none", background: "#007bff", color: "white", cursor: "pointer" }}>Change Name</button>
      </div>
      <div style={{ display: "flex", flexWrap: "wrap", justifyContent: "center", marginTop: "20px" }}>
        {postInfo.map((p) => {
          return (
            <Posts key={p.id} id={p.id} title={p.title} author={p.author} onPostSelect={onPostSelect} />
          );
        })}
      </div>
      <div style={{ display: "flex", justifyContent: "center", marginTop: "20px" }}>
        <AddPost fetchPosts={fetchPosts} />
      </div>
    </div>
  );
};
