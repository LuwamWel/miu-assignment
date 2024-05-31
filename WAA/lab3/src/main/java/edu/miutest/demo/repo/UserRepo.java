package edu.miutest.demo.repo;

import edu.miutest.demo.entity.User;

import java.util.List;

public interface UserRepo {
    List<User> findAll();
    User findById(long id);
    void save(User user);
    void delete(long id);
 //   List<Post> findPostByUserId(long id);

}
