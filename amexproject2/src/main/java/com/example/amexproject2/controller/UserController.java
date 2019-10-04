package com.example.amexproject2.controller;

import com.example.amexproject2.model.JwtResponse;
import com.example.amexproject2.model.User;
import com.example.amexproject2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }

    @PostMapping("/signup")
    public ResponseEntity<?> createUser(@RequestBody User newUser) {
        return ResponseEntity.ok(new JwtResponse(userService.createUser(newUser)));
    }
//
//    @PostMapping("/login")
//    public ResponseEntity<?> login(@RequestBody User user) {
//        return ResponseEntity.ok(new JwtResponse(userService.login(user)));
//    }
//
//    @GetMapping("/user/list/posts")
//    public Iterable<User> listPosts() {
//        return userService.listPosts();
//    }
//
//    @GetMapping("/user/list/comments")
//    public Iterable<User> listComments() {
//        return userService.listComments();
//    }

}
