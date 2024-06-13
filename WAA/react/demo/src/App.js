// App.js
import React, { useState } from 'react';
import './App.css';
import { Dashboard } from './components/Dashboard';
import PostDetails from './components/PostDetails';

function App() {
  const [selectedPostId, setSelectedPostId] = useState(null);

  const handlePostSelect = (postId) => {
    setSelectedPostId(postId);
  };

  const handlePostDelete = (deletedPostId) => {
    setSelectedPostId(null); // Close PostDetails after deletion
  };

  return (
    <div>
      <Dashboard onPostSelect={handlePostSelect} />
      {selectedPostId && <PostDetails postId={selectedPostId} onDelete={handlePostDelete} />}
    </div>
  );
}

export default App;
