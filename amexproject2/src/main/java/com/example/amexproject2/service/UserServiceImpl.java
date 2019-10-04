package com.example.amexproject2.service;

import com.example.amexproject2.model.User;
import com.example.amexproject2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.xml.stream.events.Comment;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

//    @Override
//    public User createUser(User newUser) {
//        UserRole userRole = userRoleService.getRole(newUser.getUserRole().getName());
//        newUser.setUserRole(userRole);
//        newUser.setPassword(bCryptPasswordEncoder.encode(newUser.getPassword()));
//        if(userRepository.save(newUser) != null){
//            UserDetails userDetails = loadUserByUsername(newUser.getUsername());
//            return jwtUtil.generateToken(userDetails);
//        }
//        return null;
//    }

    @Override
    public User createUser(User newUser) {
        return null;
    }

    @Override
    public String login(User user) {
        return null;
    }

    @Override
    public Iterable<User> listUsers() {
        return userRepository.findAll();
    }

    @Override
    public Iterable<Comment> listComments() {
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }
}
