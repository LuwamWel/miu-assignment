package edu.miutest.demo.controller;

import edu.miutest.demo.entity.Post;
import edu.miutest.demo.entity.Userr;
import edu.miutest.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("api/users")
public class UserController {
    @Autowired
    UserService userService;


//    @ResponseStatus(HttpStatus.OK)
//    @GetMapping("/")
//    public List<Userr> findAll(){
//        return userService.findAll();
//    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/")
    public void save(@RequestBody Userr usr){
        userService.save(usr);
    }


    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") long id){
        userService.deleteById(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}/posts")
    public List<Post> findById(@PathVariable("id") long id){
        return userService.findPostByUserId(id);
    }

    //    Make a query that will retrieve all the users that have more than (n) posts.

    @GetMapping("/")
    public List<Userr> getAllUsersWithMoreThanNPosts(@PathVariable int numOfPosts){
        return userService.getAllUsersWithMoreThanNPosts(numOfPosts);
    }

}
