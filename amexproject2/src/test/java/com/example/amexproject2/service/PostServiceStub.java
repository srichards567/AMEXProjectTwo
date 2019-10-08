package com.example.amexproject2.service;

import com.example.amexproject2.model.Post;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

public class PostServiceStub implements PostService {

    @Override
    public Post createPost(Post newPost) {
        Post post = new Post();
        post.setBody("A new post");
        return post;
    }

    @Override
    public Iterable<Post> listAllPosts() {

        List<Post> dummyPosts = new ArrayList<Post>();
        for(int i = 0; i < 10; i++) {
            Post post = new Post();
            post.setTitle("Title: " + i);
            post.setBody("Body:" + i);

            dummyPosts.add(post);
        }
        return dummyPosts;
    }

    @Override
    public Iterable<Post> listUsersPosts() {
        return null;
    }

    @Override
    public HttpStatus deleteById(Long postId) {
        return null;
    }

    @Override
    public Post getPostById(Long postId) {
        return null;
    }


}
