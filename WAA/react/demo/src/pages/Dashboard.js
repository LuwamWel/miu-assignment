import React, { useState } from "react";
import axios from "axios";
import AddPost from "../component/AddPost";
import Post from "../component/Post";
import PostDetail from "../component/PostDetail";

const Dashboard = () => {
  const [posts, setPosts] = useState([]);
  const [selectedPost, setSelectedPost] = useState(null);
  const [inputValue, setInputValue] = useState("");
  const token =
    "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzIiwiZXhwIjoxNjg2ODQ2Mzg4LCJpYXQiOjE2ODY4NDUzMDh9.Fd6Pv2Ffu-CfHVsYiAcbUSta_NlDPO90Cj5d3vhjSRCFxybz6ELf7TdyE_iiZ4ab_Q2K0GbvwGePlvEcvytdQQ";

  const fetchPosts = async () => {
    try {
      const response = await axios.get("http://localhost:8080/api/v1/posts", {
        headers: {
          Authorization: `Bearer ${token}`,
        },
      });
      setPosts(response.data);
    } catch (error) {
      console.error("Error fetching posts:", error);
    }
  };

  const fetchPostDetails = async (postId) => {
    try {
      const response = await axios.get(
        `http://localhost:8080/api/v1/posts/${postId}`,
        {
          headers: {
            Authorization: `Bearer ${token}`,
          },
        }
      );
      setSelectedPost(response.data);
    } catch (error) {
      console.error("Error fetching post details:", error);
    }
  };

  const handlePostClick = async (postId) => {
    fetchPostDetails(postId);
  };

  return (
    <div>
      <h1>Dashboard</h1>
      <div className="posts">
        <h2>Posts</h2>
        <div>
          <button onClick={fetchPosts}>ShowAllPosts</button>
        </div>
        {posts.map((post) => (
          <div key={post.id} onClick={() => handlePostClick(post.id)}>
            <Post
              title={post.title}
              content={post.content}
              author={post.author}
            />
          </div>
        ))}
      </div>
      {selectedPost && (
        <div>
          <h2>Post Details</h2>
          <PostDetail post={selectedPost} />
        </div>
      )}
      <div>
        <h2>Add Post</h2>
        <AddPost token={token} />
      </div>
    </div>
  );
};

export default Dashboard;
