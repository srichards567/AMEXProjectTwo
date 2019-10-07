package com.example.amexproject2.model;

import javax.persistence.*;

@Entity
public class Comment {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column
    public String body;

    @Column
    public String userId;

    @Column
    public String postId;


    @OneToOne(mappedBy = "Comment",
            cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public Post post;

    @OneToOne(mappedBy = "User",
            cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    //    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @JoinTable(name = "user_comment",
//            joinColumns = {@JoinColumn(name = "comment_id")},
//            inverseJoinColumns = {@JoinColumn(name = "postId")},
//            joinColumns = {@JoinColumn(name = "user_id")})

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
