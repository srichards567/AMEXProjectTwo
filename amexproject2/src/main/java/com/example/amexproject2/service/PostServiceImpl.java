package com.example.amexproject2.service;

import com.example.amexproject2.controller.SecurityController;
import com.example.amexproject2.model.Post;
import com.example.amexproject2.model.User;
import com.example.amexproject2.repository.PostRepository;
import com.example.amexproject2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    SecurityController securityController;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Post createPost(Post newPost) {
        User userWhoPosts = userRepository.findByUsername(securityController.getCurrentUsername());
        newPost.setUser(userWhoPosts);
        return postRepository.save(newPost);
    }

    @Override
    public HttpStatus deleteById(Long postId) {

        //        String currentUsername = null;
//
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        if (!(authentication instanceof AnonymousAuthenticationToken)) {
//            currentUsername = authentication.getName();
//        }

        String currentUsername = securityController.getCurrentUsername();

        if (postRepository.findById(postId).get().getUser().getUsername().equals(currentUsername)) {
            postRepository.deleteById(postId);
            return HttpStatus.OK;
        } else {
            return HttpStatus.BAD_REQUEST;
        }
    }

    public Post getPostById(Long postId) {
        return postRepository.findById(postId).get();
    }


    @Override
    public Iterable<Post> listAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public Iterable<Post> listUsersPosts() {
        Long userId = userRepository.findByUsername(securityController.getCurrentUsername()).getId();
        return postRepository.findByUserId(userId);
    }

}