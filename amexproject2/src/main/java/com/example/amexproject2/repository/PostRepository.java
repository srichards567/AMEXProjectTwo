package com.example.amexproject2.repository;

import com.example.amexproject2.model.Post;
import com.example.amexproject2.model.User;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends CrudRepository<Post, Long> {
//    @Query("FROM Post u WHERE u.title = ?1")
//    public Post findPostByPostTitle(String title);

    @Query("FROM Post p WHERE p.user_id = ?1")
    public Iterable<Post> findByUserId(Long userId);
}
