package edu.miutest.demo.service;

import edu.miutest.demo.entity.Post;
import edu.miutest.demo.entity.Userr;

import java.util.List;

public interface UserService {
    public List<Userr> findAll();
    public void save(Userr user);
    public Userr findById(long id);
    public void deleteById(long id);
    public List<Post> findPostByUserId(long id);
    public List<Userr> getAllUsersWithMoreThanNPosts(Integer n);

}
