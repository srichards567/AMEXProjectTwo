package com.example.amexproject2.service;

import com.example.amexproject2.model.User;
import org.hibernate.dialect.PostgreSQL9Dialect;

import javax.xml.stream.events.Comment;
import org.springframework.security.core.userdetails.UserDetailsService;


public interface UserService extends UserDetailsService {
    public User createUser(User newUser);

    public String login(User user);

//    public Iterable<Post> listPosts();

    public Iterable<User> listUsers();

    public Iterable<Comment> listComments();

//    public Profile getProfile();
}
