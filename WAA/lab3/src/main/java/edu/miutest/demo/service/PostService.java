package edu.miutest.demo.service;

import edu.miutest.demo.entity.Post;
import edu.miutest.demo.entity.dto.response.PostSimpleDto;

import java.util.List;

public interface PostService {
    public List<Post> findAll();
    public void save(Post p);
    public PostSimpleDto findById(long id);
    public void delete(long id);
    public void updatePostById(long id, Post p);





}
