package com.example.amexproject2.controller;

import com.example.amexproject2.model.Comment;
import com.example.amexproject2.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    CommentService commentService;

    @PostMapping("/{username}/{post_id}")
    public Comment createComment(@PathVariable String username, @PathVariable Long post_id, @RequestBody Comment newComment) {
        return commentService.createComment(username, post_id, newComment);
    }

    @GetMapping("/user/{user_id}/list")
    public Iterable<Comment> listAllComments(@PathVariable Long user_id) {

        return commentService.listAllComments();
    }

    @DeleteMapping("/{comment_id}")
    public HttpStatus deleteById(@PathVariable Long comment_id) {
        return commentService.deleteComment(comment_id);
    }
}
