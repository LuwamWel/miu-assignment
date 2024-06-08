package edu.miutest.demo.service;

import edu.miutest.demo.entity.Post;
import edu.miutest.demo.entity.Userr;
import edu.miutest.demo.repo.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<Userr> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void save(Userr u) {
        userRepository.save(u);
    }

    @Override
    public Userr findById(long id) {
        return modelMapper.map(userRepository.findById(id), Userr.class);
    }

    @Override
    public void deleteById(long id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<Post> findPostByUserId(long id) {
        Userr usr = userRepository.findById(id).orElse(null);
        return usr.getPosts().stream().map(post -> modelMapper.map(post, Post.class)).toList();
    }
    @Override
    public List<Userr> findUsersWithMoreThanNPosts(Integer n){
        List<Userr> usersList =  userRepository.findAll();
        return usersList.stream().filter(usr ->usr.getPosts().size() > n).collect(Collectors.toList());
    }


}
