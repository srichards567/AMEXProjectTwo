package com.example.amexproject2.controller;

import com.example.amexproject2.model.JwtResponse;
import com.example.amexproject2.model.User;
import com.example.amexproject2.model.UserProfile;
import com.example.amexproject2.service.UserProfileService;
import com.example.amexproject2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    UserProfileService userProfileService;

    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }

    @PostMapping("/signup")
    public ResponseEntity<?> createUser(@RequestBody User newUser) {
        return ResponseEntity.ok(new JwtResponse(userService.createUser(newUser)));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        return ResponseEntity.ok(new JwtResponse(userService.login(user)));
    }

    @GetMapping("/profile/{username}")
    public UserProfile viewUserProfile(@PathVariable String username) {
        return userProfileService.getUserProfile(username);
    }

    @PostMapping("/profile/{username}")
    public UserProfile createUserProfile(@PathVariable String username, @RequestBody UserProfile newUserProfile) {
        return userProfileService.createUserProfile(username, newUserProfile);
    }

    // user can view and create a profile

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
