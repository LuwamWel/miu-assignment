// src/components/Dashboard.js
import React, { useState } from 'react';
import Posts from './Posts';

const Dashboard = () => {
  const [posts, setPosts] = useState([
    { id: 111, title: 'Happiness', author: 'John', content: 'Content about Happiness' },
    { id: 112, title: 'MIU', author: 'Dean', content: 'Content about MIU' },
    { id: 113, title: 'Enjoy', author: 'Jasmine', content: 'Content about Enjoying life' }
  ]);

  const [newTitle, setNewTitle] = useState('');

  const handleTitleChange = () => {
    const updatedPosts = posts.map(post => 
      post.id === 111 ? { ...post, title: newTitle } : post
    );
    setPosts(updatedPosts);
  };

  return (
    <div>
      <h1>Dashboard</h1>
      <Posts posts={posts} />
      <input 
        type="text" 
        value={newTitle} 
        onChange={(e) => setNewTitle(e.target.value)} 
        placeholder="Title " 
      />
      <br/>
      <br/>
      <button onClick={handleTitleChange}>Change Name</button>
    </div>
  );
};

export default Dashboard;
