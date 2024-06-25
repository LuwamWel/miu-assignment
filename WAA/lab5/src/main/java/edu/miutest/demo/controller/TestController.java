package edu.miutest.demo.controller;

import edu.miutest.demo.entity.Post;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tests")
public class TestController {

    @PostMapping("")
    public Post post(@RequestBody  Post b) {
        return b;
    }
}
