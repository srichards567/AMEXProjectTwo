package com.example.amexproject2.repository;

import com.example.amexproject2.model.Comment;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.Id;

public interface CommentRepository extends CrudRepository<Comment, Long> {

}
