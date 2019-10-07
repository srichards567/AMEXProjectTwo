package com.example.amexproject2.controller;

import com.example.amexproject2.model.Comment;
import com.example.amexproject2.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class CommentController {
    @Autowired
    CommentService commentService;

    @PostMapping("/{username}/comment/{post_id}")
    public Comment createComment(@PathVariable String username, @PathVariable Long post_id, @RequestBody Comment newComment) {
        return commentService.createComment(username, post_id, newComment);
    }

    @GetMapping("/comment/list")
    public Iterable<Comment> listAllComments() {
        return commentService.listAllComments();
    }

    @DeleteMapping("/comment/{comment_id}")
    public HttpStatus deleteById(@PathVariable Long comment_id) {
        return commentService.deleteComment(comment_id);
    }
}
