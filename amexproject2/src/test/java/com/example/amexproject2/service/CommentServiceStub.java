package com.example.amexproject2.service;

import com.example.amexproject2.model.Comment;
import org.springframework.http.HttpStatus;

public class CommentServiceStub implements CommentService{
    @Override
    public Comment createComment(Long postId, Comment newComment) {
        newComment = new Comment();
        newComment.setBody("This is a comment.");
        return newComment;
    }

    @Override
    public HttpStatus deleteComment(Long id) {
        return null;
    }

    @Override
    public Iterable<Comment> listAllComments() {
        return null;
    }

    @Override
    public Iterable<Comment> listAllUsersComments() {
        return null;
    }

    @Override
    public Iterable<Comment> listAllPostsComments(Long postId) {
        return null;
    }
}
