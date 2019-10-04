package com.example.amexproject2.service;

import com.example.amexproject2.model.Post;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {
    @Override
    public Post createPost(Post newPost) {
        return null;
    }

    @Override
    public HttpStatus deletePost(Long id) {
        return null;
    }

    @Override
    public Post getPostById(Long id) {
        return null;
    }

    @Override
    public Iterable<Post> listAllPosts() {
        return null;
    }
}
