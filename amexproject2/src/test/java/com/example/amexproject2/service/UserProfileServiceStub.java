package com.example.amexproject2.service;

import com.example.amexproject2.model.User;
import com.example.amexproject2.model.UserProfile;

public class UserProfileServiceStub implements UserProfileService {
    @Override
    public UserProfile createUserProfile(UserProfile newUserProfile) {
        UserProfile userProfile = new UserProfile();
        userProfile.setAddress("Scranton, PA");
        userProfile.setAltEmail("pam@aol.com");
        userProfile.setMobile("570-343-3400");

        return userProfile;
    }

    @Override
    public UserProfile getUserProfile() {
        UserProfile userProfile = new UserProfile();
        userProfile.setMobile("999-999-9999");
        userProfile.setAltEmail("jsmith@mail.com");
        userProfile.setAddress("555 Hope Lane");

        return userProfile;
    }
}
