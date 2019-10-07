package com.example.amexproject2.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")

@Entity
@Table(name = "users")
public class User {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

//    @Id
//    @Column(name = "user_id")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    public Long id;
//
//    @OneToOne(
//            cascade = {CascadeType.ALL},
//            fetch = FetchType.LAZY,
//            mappedBy = "user_profile")  //Refers to parent field of the Child class
//    private UserProfile userProfile;

    @Column(unique=true)
    public String username;

    @Column
    public String password;

    @Column(unique = true)
    public String email;


//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private List<Post> posts;
//
//    public Post getPost() {
//        return post;
//    }
//
//    public void setPost(Post post) {
//        this.post = post;
//    }

    // creates a users_posts
//    @OneToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
//    @JoinTable(name = "user_posts",
//            joinColumns = {@JoinColumn(name = "user_id")},
//            inverseJoinColumns = @JoinColumn(name = "post_id"))
//    private List<Post> posts;
//
//
//    public List<Post> addUserPost (Post newPost){
//        if(posts == null)
//            posts = new ArrayList<>();
//        posts.add(newPost);
//
//        return posts;
//    }
//
//    public List<Post> deleteUserPost (Post post) {
//        try {
//            posts.remove(post);
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//        return posts;
//    }

    public User() {}

    @OneToOne(cascade =
            CascadeType.ALL)
    @JoinColumn(name="profile_id")
    private UserProfile userProfile;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

//    public void setUserProfileId(Long id) {
//        this.userProfile.setId(id);
//    }

    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }

    public UserProfile getUserProfile() {
        return userProfile;
    }
}

