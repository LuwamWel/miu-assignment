package edu.miutest.demo.service;

import edu.miutest.demo.entity.User;

import java.util.List;

public interface UserService {
    public List<User> findAll();
    public void save(User user);
    public User findById(long id);
    public void delete(long id);
//    public List<Post> findPostByUserId(long id);

//  public void update(long id, Post p);
}
