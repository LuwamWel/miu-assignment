package edu.miutest.demo.service;

import edu.miutest.demo.entity.Post;
import edu.miutest.demo.entity.dto.response.PostSimpleDto;
import edu.miutest.demo.repo.PostRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    PostRepository postRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<Post> findAll(){
        return postRepository.findAll();
    }

    @Override
    public void save(Post p) {
        postRepository.save(p);
    }

    @Override
    public PostSimpleDto findById(long id) {
        return modelMapper.map(postRepository.findById(id), PostSimpleDto.class);
    }

    @Override
    public void delete(long id) {
        postRepository.deleteById(id);
    }

    @Override
    public void updatePostById(long id, Post p) {
        Post postEntity = postRepository.findById(id).get();
        postEntity.setTitle(p.getTitle());
        postEntity.setContent(p.getContent());
        postEntity.setAuthor(p.getAuthor());
        postRepository.save(postEntity);
    }

//    @Override
//    public List<Post> findPostsByTitle(String title){
//        List<Post> postsList = postRepository.findAll();
//        return postsList.stream().filter(post ->post.getTitle().equals(title)).collect(Collectors.toList());
//    }

    @Override
    public List<Post> findPostsByTitle(String title){
        return postRepository.findByTitleContaining(title);
    }


}
