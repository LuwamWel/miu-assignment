package edu.miutest.demo.repo;

import edu.miutest.demo.entity.Post;

import java.util.List;

public interface PostRepo {
    List<Post> findAll();
    Post findById(long id);
    void save(Post p);
    void delete(long id);
    void updatePostById(long id, Post p);


}


