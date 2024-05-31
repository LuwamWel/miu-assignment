package edu.miutest.demo.service;

import edu.miutest.demo.entity.Userr;
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
    public List<Userr> findAll() {
        return userRepo.findAll();
    }

    @Override
    public void save(Userr u) {
        userRepo.save(u);
    }

    @Override
    public Userr findById(long id) {
        return modelMapper.map(userRepo.findById(id), Userr.class);
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
//    public void update(long id, Userr usr) {
//        userRepo.update(id, usr);
//    }

}
