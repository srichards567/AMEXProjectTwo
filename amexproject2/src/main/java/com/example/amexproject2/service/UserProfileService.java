package com.example.amexproject2.service;

import com.example.amexproject2.model.UserProfile;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface UserProfileService {

    public UserProfile createUserProfile(String username, UserProfile newUserProfile);

    public UserProfile getUserProfile(String username);
}
