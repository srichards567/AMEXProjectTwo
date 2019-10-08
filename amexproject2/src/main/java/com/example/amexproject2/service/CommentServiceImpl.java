package com.example.amexproject2.service;
import com.example.amexproject2.controller.SecurityController;
import com.example.amexproject2.model.Comment;
import com.example.amexproject2.model.Post;
import com.example.amexproject2.model.User;
import com.example.amexproject2.repository.CommentRepository;
import com.example.amexproject2.repository.PostRepository;
import com.example.amexproject2.repository.UserRepository;
import com.example.amexproject2.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PostRepository postRepository;

    @Autowired
    SecurityController securityController;


    @Override
    public Comment createComment(Long postId, Comment newComment) {
        User userWhoComments = userRepository.findByUsername(securityController.getCurrentUsername());
        newComment.setUser(userWhoComments);
        Post postWithComment = postRepository.findById(postId).get();
        newComment.setPost(postWithComment);
        return commentRepository.save(newComment);
    }

    @Override
    public HttpStatus deleteComment(Long id) {
        commentRepository.deleteById(id);
        return HttpStatus.OK;
    }

    @Override
    public Iterable<Comment> listAllComments() {
        return commentRepository.findAll();
    }

    @Override
    public Iterable<Comment> listAllUsersComments() {
        Long userId = userRepository.findByUsername(securityController.getCurrentUsername()).getId();
        return commentRepository.findByUserId(userId);
    }


    public Iterable<Comment> listAllPostsComments(Long postId){
        return commentRepository.findByPostId(postId);
    }
}