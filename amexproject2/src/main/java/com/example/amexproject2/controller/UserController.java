package com.example.amexproject2.controller;

import com.example.amexproject2.config.IAuthenticationFacade;
import com.example.amexproject2.model.JwtResponse;
import com.example.amexproject2.model.User;
import com.example.amexproject2.model.UserProfile;
import com.example.amexproject2.service.UserProfileService;
import com.example.amexproject2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class UserController {


    @Autowired
    UserService userService;


//    @Autowired
//    UserProfileService userProfileService;
//
    // ======== for testing purposes =======
    private UserProfileService userProfileService;

    @Autowired
    public void setUserProfileService(UserProfileService userProfileService){
        this.userProfileService = userProfileService;
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }

    // create a user
    @PostMapping("/signup")
    public ResponseEntity<?> createUser(@RequestBody User newUser) {
        return ResponseEntity.ok(new JwtResponse(userService.createUser(newUser)));
    }

    // user login
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        return ResponseEntity.ok(new JwtResponse(userService.login(user)));
    }

    // view a user profile
    @GetMapping("/profile")
    public UserProfile viewUserProfile() {
        return userProfileService.getUserProfile();
    }

    // create a user profile
    @PutMapping("/profile")
    @PostMapping("/profile")
    public UserProfile createUserProfile(@RequestBody UserProfile newUserProfile) {
        return userProfileService.createUserProfile(newUserProfile);
    }

    @GetMapping("/user/list/all")
    public Iterable<User> listAllUsers() {
        return userService.listUsers();
    }
}
