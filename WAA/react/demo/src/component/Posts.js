import React from "react";
import Post from "./Post";

const postsData = [
  {
    id: 2,
    title: "Post 1",
    content: "This is the first post.",
    author: "AuthorOne",
  },
  {
    id: 3,
    title: "Post 2",
    content: "This is the second post.",
    author: "AuthorTwo",
  },
  {
    id: 4,
    title: "Post 3",
    content: "This is the third post.",
    author: "AuthorThree",
  },
];

const Posts = ({ title, selectPost }) => {
  return (
    <div>
      {postsData.map((post, id) => (
        <div onClick={() => selectPost(post)} key={id}>
          <Post
            title={index === 0 ? title : post.title}
            content={post.content}
            author={post.author}
          />
        </div>
      ))}
    </div>
  );
};

export default Posts;
