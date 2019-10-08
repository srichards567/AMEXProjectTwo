package com.example.amexproject2.controller;

import com.example.amexproject2.model.User;
import com.example.amexproject2.model.UserProfile;
import com.example.amexproject2.service.UserProfileServiceStub;
import org.junit.Before;
import org.junit.Test;

public class UserProfileControllerTest {

    private UserController userController;

    private User user;

    @Before
    public void initializeUserProfileController(){
        userController = new UserController();
        userController.setUserProfileService(new UserProfileServiceStub());
    }

    @Test
    public void createUserProfile_saveUserProfile_Success() {
        User mockUser = new User();
        mockUser.setUsername("pam");
        mockUser.setPassword("lovesjim");
        mockUser.setEmail("pamh@dm.com");

        UserProfile pamUserProfile = new UserProfile();


        pamUserProfile.setAddress("Scranton, PA");
        pamUserProfile.setAltEmail("pam@aol.com");
        pamUserProfile.setMobile("570-343-3400");


    }
}
