package edu.miutest.demo.service;

import edu.miutest.demo.entity.Comment;
import edu.miutest.demo.entity.Userr;

import java.util.List;
import java.util.Optional;

public interface CommentService {
    public List<Comment> getAllCommentsByPostId(Long postId);
    public void addComment(Comment comment);
    public Optional<Comment> getCommentById(Long commentId);

}
