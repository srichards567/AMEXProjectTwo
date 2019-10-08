package com.example.amexproject2.controller;

import com.example.amexproject2.model.Post;
import com.example.amexproject2.model.User;
import com.example.amexproject2.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Entity;

@RestController
@RequestMapping("/post")
public class PostController {

    PostService postService;

    @Autowired
    public void setPostService(PostService postService) {
        this.postService = postService;
    }

    // create a post
    @PostMapping
    public Post createPost(@RequestBody Post newPost) {
        return postService.createPost(newPost);
    }

    // delete a post
    @DeleteMapping("/{postId}")
    public HttpStatus deletePost(@PathVariable Long postId) {
        return postService.deleteById(postId);
    }

    // get a specific post
    @GetMapping("/{postId}")
    public Post getPostById (@PathVariable Long postId) {
        return postService.getPostById(postId);
    }

    // get all posts
    @GetMapping("/list/all")
    public Iterable<Post> listAllPosts()  {
        return postService.listAllPosts();
    }

    // get all posts by user
    @GetMapping("/list")
    public Iterable<Post> listPosts() {
        return postService.listUsersPosts();
    }

}