package com.example.amexproject2.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.List;

@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")


@Entity
@Table(name="user_profile")
public class UserProfile {

    @Id
    @Column(name = "id")
    public Long id;

    @Column
    public String mobile;

    @Column
    public String address;

    @Column
    public String altEmail;

    @OneToOne
    @MapsId
    private User user;

    public UserProfile() {}

    // getters and setters

    public void setId (Long id) {
        this.id = id;
    }

    public Long getId () {
        return id;
    }

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
}