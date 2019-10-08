package com.example.amexproject2.controller;

import com.example.amexproject2.model.Post;
import com.example.amexproject2.service.PostService;
import com.example.amexproject2.service.PostServiceStub;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PostControllerTest {

    private PostController postController;

    @Before
    public void initializePostController() {
        postController = new PostController();
        postController.setPostService(new PostServiceStub());
    }

    @Test
    public void createPost_SavePost_Success() {
        Post post = new Post();

        post.setBody("A new post");

        Post newPost = postController.createPost(post);

        Assert.assertNotNull(newPost.getBody());
        Assert.assertEquals(newPost.getBody(), post.getBody());
    }

    @Test
    public void postList_ListAllPosts_Success() {
        Iterable<Post> posts = postController.listAllPosts();
//        posts.forEach(post -> {
//            System.out.println(post.getTitle() + "\n" + post.getBody());
//        });
        Assert.assertNotNull(posts);
    }

}
