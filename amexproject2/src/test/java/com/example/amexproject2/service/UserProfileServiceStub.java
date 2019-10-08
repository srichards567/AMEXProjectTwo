package com.example.amexproject2.service;

import com.example.amexproject2.model.User;
import com.example.amexproject2.model.UserProfile;

public class UserProfileServiceStub implements UserProfileService {
    @Override
    public UserProfile createUserProfile(String username, UserProfile newUserProfile) {
        UserProfile userProfile = new User()
    }

    @Override
    public UserProfile getUserProfile(String username) {
        return null;
    }
}
