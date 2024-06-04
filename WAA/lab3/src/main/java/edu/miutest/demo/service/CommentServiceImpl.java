package edu.miutest.demo.service;

import edu.miutest.demo.entity.Comment;
import edu.miutest.demo.entity.Post;
import edu.miutest.demo.entity.Userr;
import edu.miutest.demo.repo.CommentRepository;
import edu.miutest.demo.repo.PostRepository;
import edu.miutest.demo.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService{

    @Autowired
    CommentRepository commentRepository;
    @Autowired
    PostRepository postRepository;
    @Autowired
    UserRepository userRepository;

    @Override
    public List<Comment> getAllCommentsByPostId(Long postId) {
        Optional<Post> p = postRepository.findById(postId);
        if(p.isPresent()){
            return commentRepository.findAll();
        }
        return null;
        //return commentRepository.getAllCommentsByPostId(postId);
    }
    @Override
    public void addComment(Comment comment){
        commentRepository.save(comment);
    }

    @Override
    public Optional<Comment> getCommentById(Long commentId) {
         return commentRepository.findById(commentId);
    }

}








