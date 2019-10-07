package com.example.amexproject2.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import sun.jvm.hotspot.memory.Generation;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="user_profile")
public class UserProfile {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "profile_id", nullable = false, unique = true)
//    private User user;

    @Column
    public String mobile;

    @Column
    public String address;

    @Column
    public String altEmail;

    @JsonIgnore
    @OneToOne(mappedBy = "userProfile",
    cascade = {CascadeType.DETACH,
    CascadeType.MERGE, CascadeType.MERGE,
    CascadeType.PERSIST,
    CascadeType.REFRESH})
    public User user;



//    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL,
//            fetch = FetchType.LAZY, optional = false)
//    private User user;

    public UserProfile(){}

    // getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

//    public void setUser(User user) {
//        this.user = user;
//    }
//
//    public User getUser() {
//        return user;
//    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getMobile() {
        return mobile;
    }


    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public String getAltEmail() {
        return altEmail;
    }

    public void setAltEmail(String altEmail) {
        this.altEmail = altEmail;
    }

    //getter method to retrieve the UserId
    public Long getUserId(){
        return user.getId();
    }


    @JsonIgnore
    public User getUser() {
        return user;
    }

    @JsonIgnore
    public void setUser(User user) {
        this.user = user;
    }
}