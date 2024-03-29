package com.example.amexproject2.controller;

import com.example.amexproject2.model.Comment;
import com.example.amexproject2.repository.CommentRepository;
import com.example.amexproject2.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comment")
public class CommentController {
    CommentService commentService;

    @Autowired
    SecurityController securityController;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    public void setCommentService(CommentService commentService) {
        this.commentService = commentService;
    }


    // create a comment
    @PostMapping("/{post_id}")
    public Comment createComment(@PathVariable Long post_id, @RequestBody Comment newComment) {
        return commentService.createComment(post_id, newComment);
    }

    @GetMapping("/{post_id")
    public Iterable<Comment> viewPostComments(@PathVariable Long post_id) {
        return commentService.listAllPostsComments(post_id);
    }

    // list a user's comments
    @GetMapping("/list")
    public Iterable<Comment> listAllUserComments() {
        return commentService.listAllUsersComments();
    }

    // list all comments
    @GetMapping("/list/all")
    public Iterable<Comment> listAllComments() {
        return commentService.listAllComments();
    }

    // delete a comment
    @DeleteMapping("/{comment_id}")
    public HttpStatus deleteById(@PathVariable Long comment_id) {
        String currentUsername = securityController.getCurrentUsername();
        if (commentRepository.findById(comment_id).get().getUser().getUsername().equals(currentUsername)) {
            commentRepository.deleteById(comment_id);
            return HttpStatus.valueOf(200);
        } else {
            return HttpStatus.valueOf(400);
        }
    }
}
