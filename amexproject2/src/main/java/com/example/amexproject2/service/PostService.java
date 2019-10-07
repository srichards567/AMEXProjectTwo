package com.example.amexproject2.service;

// The Post Service holds the methods
// for the user to do

import com.example.amexproject2.model.Post;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostService {

    // make a post
    public Post createPost(Post newPost);

    // delete post
    public HttpStatus deleteById(Long postId);

    // get specific post
    public Post getPostById(Long postId);
      //  public Post getPostByPostTitle(String postTitle);

    // get all posts
    public Iterable<Post> listAllPosts();


}
