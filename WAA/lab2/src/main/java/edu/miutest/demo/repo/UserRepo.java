package edu.miutest.demo.repo;

import edu.miutest.demo.entity.Userr;

import java.util.List;

public interface UserRepo {
    List<Userr> findAll();
    Userr findById(long id);
    void save(Userr usr);
    void delete(long id);
 //   List<Post> findPostByUserId(long id);

}
