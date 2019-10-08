package com.example.amexproject2.controller;

import com.example.amexproject2.model.User;
import com.example.amexproject2.model.UserProfile;
import com.example.amexproject2.service.UserProfileServiceStub;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UserProfileControllerTest {

    // We post and get a profile in our userController
    private UserController userController;

    @Before
    public void initializeUserProfileController(){
        userController = new UserController();
        userController.setUserProfileService(new UserProfileServiceStub());
    }

    // ============ TEST FOR CREATE A USER PROFILE ======================
    @Test
    public void createUserProfile_saveUserProfile_Success() {
        UserProfile pamUserProfile = new UserProfile();
        pamUserProfile.setAltEmail("pam@aol.com");
        pamUserProfile.setMobile("570-343-3400");
        pamUserProfile.setAddress("Scranton, PA");

        UserProfile newProfile = userController.createUserProfile(pamUserProfile);

        Assert.assertNotNull(newProfile);
        Assert.assertEquals(pamUserProfile.getAltEmail(), newProfile.getAltEmail());
        Assert.assertEquals(pamUserProfile.getMobile(), newProfile.getMobile());
        Assert.assertEquals(pamUserProfile.getAddress(), newProfile.getAddress());
    }

    // ================== TEST GET PROFILE ===============================

    @Test
    public void getUserProfile_returnUserProfile_Success() {

        UserProfile tempUserProfile = userController.viewUserProfile();
        Assert.assertNotNull(tempUserProfile.getAltEmail());
        Assert.assertNotNull(tempUserProfile.getMobile());
        Assert.assertNotNull(tempUserProfile.getAddress());
        }

}
