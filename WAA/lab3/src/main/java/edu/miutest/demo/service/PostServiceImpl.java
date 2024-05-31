package edu.miutest.demo.service;

import edu.miutest.demo.entity.Post;
import edu.miutest.demo.entity.dto.response.PostSimpleDto;
import edu.miutest.demo.repo.PostRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    PostRepo postRepo;
    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<Post> findAll(){
        return postRepo.findAll();
    }

    @Override
    public void save(Post p) {
        postRepo.save(p);
    }

    @Override
    public PostSimpleDto findById(long id) {
        return modelMapper.map(postRepo.findById(id), PostSimpleDto.class);
    }

    @Override
    public void delete(long id) {
        postRepo.delete(id);
    }

//    @Override
//    public void update(long id, Post p) {
//        postRepo.update(id, p);
//    }
}
