package com.example.amexproject2.repository;

import com.example.amexproject2.model.User;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    @Query("FROM User u WHERE u.username = ?1 and u.password = ?2")
//    public String login(String username, String password);

    public User findByUsername(String username);
}
