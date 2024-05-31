package edu.miutest.demo.controller;

import edu.miutest.demo.entity.User;
import edu.miutest.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;


    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/")
    public List<User> findAll(){
        return userService.findAll();
    }



    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/")
    public void save(@RequestBody User user){
        userService.save(user);
    }


    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") long id){
        userService.delete(id);
    }



//    @ResponseStatus(HttpStatus.OK)
//    @GetMapping("/{id}/posts")
//    public List<Post> findById(@PathVariable("id") long id){
//        return userService.findPostByUserId(id);
//    }

//    @ResponseStatus(HttpStatus.OK)
//    @PutMapping("/{id}")
//    public void update(@PathVariable("id") long id, @RequestBody User u){
//        postService.update(id, u);
//    }
}
