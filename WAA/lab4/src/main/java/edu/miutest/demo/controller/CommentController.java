package edu.miutest.demo.controller;

import edu.miutest.demo.entity.Comment;
import edu.miutest.demo.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/comments")
public class CommentController {
    @Autowired
    CommentService commentService;

@ResponseStatus(HttpStatus.OK)
@GetMapping("/")
    public List<Comment> getAllCommentsByPostId(@PathVariable Long postId){
        return commentService.getAllCommentsByPostId(postId);
    }

@ResponseStatus(HttpStatus.CREATED)
@PostMapping("/")
    public void addComment(@RequestBody Comment comment){
        commentService.addComment(comment);
}

@ResponseStatus(HttpStatus.OK)
@GetMapping("/{id}")
    public Comment getCommentById(@PathVariable("id") Long commentId){
        return commentService.getCommentById(commentId).orElse(null);
}


}
