package com.example.amexproject2.service;

import com.example.amexproject2.model.User;
import com.example.amexproject2.model.UserProfile;
import org.hibernate.dialect.PostgreSQL9Dialect;

import javax.xml.stream.events.Comment;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public interface UserService extends UserDetailsService {
    public User getUser(String username);

    public String createUser(User newUser);

    public String login(User user);

//    public Iterable<Post> listPosts();

    public Iterable<User> listUsers();

    public Iterable<Comment> listComments();

//    public Profile getProfile();

    public UserProfile createUserProfile(UserProfile newUserProfile);
}
