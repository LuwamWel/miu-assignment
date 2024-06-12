import React from "react";

const Post = ({post}) => {
    return (
        <div className="Content">
            
            <div className="Field" >

                <h3> Id: {post.id}</h3>
                <h3> Title: {post.title}</h3>
                <h3> Author: {post.author}</h3>

            </div>
        </div>
    );
}

export default Post