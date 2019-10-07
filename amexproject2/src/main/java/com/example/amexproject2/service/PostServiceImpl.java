package com.example.amexproject2.service;

import com.example.amexproject2.model.Post;
import com.example.amexproject2.model.User;
import com.example.amexproject2.repository.PostRepository;
import com.example.amexproject2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    PostRepository postRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public Post createPost(String username,
                           Post newPost) {
        User userWhoPosts = userRepository.findByUsername(username);
        //userWhoPosts.addUserPost(newPost);
        newPost.setUser(userWhoPosts);
        return postRepository.save(newPost);
    }

    @Override
    public HttpStatus deleteById(Long postId){
//        Optional<Post> postToDelete = postRepository.findById(postId);
//        postRepository.delete(postToDelete);

        postRepository.deleteById(postId);
        return HttpStatus.OK;
    }


    // get specific post
//    public Post getPostByPostTitle(String title){
//        return postRepository.findPostByPostTitle(title);
//    }

    public Post getPostById(Long postId) {
        return postRepository.findById(postId).get();
    }

    @Override
    public Iterable<Post> listAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public Iterable<Post> listUsersPosts(Long userId) {
        return postRepository.findByUserId(userId);
    }
}
