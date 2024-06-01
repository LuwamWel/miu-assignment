package edu.miutest.demo.controller;

import edu.miutest.demo.entity.Post;
import edu.miutest.demo.entity.dto.response.PostSimpleDto;
import edu.miutest.demo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {
    @Autowired
    PostService postService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/")
    public List<Post> findAll(){
        return postService.findAll();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public PostSimpleDto findById(@PathVariable("id") long id){
        return postService.findById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/")
    public void save(@RequestBody Post p){
        postService.save(p);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") long id){
        postService.delete(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public void updatePostById(@PathVariable("id") long id, @RequestBody Post p){
        postService.updatePostById(id, p);
    }

}
