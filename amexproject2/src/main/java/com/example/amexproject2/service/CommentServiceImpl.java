package com.example.amexproject2.service;
import com.example.amexproject2.model.Comment;
import com.example.amexproject2.repository.CommentRepository;
import com.example.amexproject2.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentRepository commentRepository;
    @Override
    public Comment createComment(Comment newComment) {
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
}