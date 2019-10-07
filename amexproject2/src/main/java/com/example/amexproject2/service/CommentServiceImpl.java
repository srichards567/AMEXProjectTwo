package com.example.amexproject2.service;

import com.example.amexproject2.model.Comment;
import com.example.amexproject2.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {
    @Override
    public Comment createComment(Comment newComment) {
        return null;
    }

    @Override
    public HttpStatus deleteComment(Long id) {
        return null;
    }

    @Override
    public Iterable<Comment> listAllComments() {
        return null;
    }
//    @Override
//    public Comment createComment(Comment newComment) {
//        return
//    }
}
