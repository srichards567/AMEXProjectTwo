package com.example.amexproject2.service;

import com.example.amexproject2.model.Comment;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public interface CommentService {
    public Comment createComment(Comment newComment);

    public HttpStatus deleteComment(Long id);

    public Iterable<Comment> listAllComments();
}
