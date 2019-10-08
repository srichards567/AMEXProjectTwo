package com.example.amexproject2.repository;

import com.example.amexproject2.model.Comment;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.Id;

public interface CommentRepository extends CrudRepository<Comment, Long> {
    @Query("FROM Comment c WHERE c.user_id = ?1")
    public Iterable<Comment> findByUserId(Long userId);

    @Query("FROM Comment c WHERE c.post_id = ?1" )
    public Iterable<Comment> findByPostId(Long postId);
}
