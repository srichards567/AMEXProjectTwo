package com.example.amexproject2.controller;

import com.example.amexproject2.model.Post;
import com.example.amexproject2.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Entity;

@RestController
public class PostController {

    @Autowired
    PostService postService;

    // create a post
    @PostMapping("/post")
    public Post createPost(@RequestBody Post newPost) {
        return postService.createPost(newPost);
    }

    // delete a post
    @DeleteMapping("/post/{id}")
    public HttpStatus deletePost(@PathVariable Long postId) {
        return postService.deleteById(postId);
    }

    // get a specific post
    @GetMapping("/post/{id}")
    public Post getPostByTitle (@PathVariable Long postId) {
        return postService.getPostById(postId);
    }

    // get a specific post
    @GetMapping("/post/list")
    public Iterable<Post> listAllPosts()  {
        return postService.listAllPosts();
    }

}
