package edu.miutest.demo.service;

import edu.miutest.demo.entity.User;
import edu.miutest.demo.repo.UserRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepo userRepo;
    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<User> findAll() {
        return userRepo.findAll();
    }

    @Override
    public void save(User u) {
        userRepo.save(u);
    }

    @Override
    public User findById(long id) {
        return modelMapper.map(userRepo.findById(id), User.class);
    }

    @Override
    public void delete(long id) {
        userRepo.delete(id);
    }

//    @Override
//    public List<Post> findPostByUserId(long id) {
//        return userRepo.findPostByUserId(id);
//    }

//    @Override
//    public void update(long id, User usr) {
//        userRepo.update(id, usr);
//    }

}
