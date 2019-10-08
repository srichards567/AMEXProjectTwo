package com.example.amexproject2.service;

import com.example.amexproject2.model.User;
import com.example.amexproject2.model.UserProfile;
import com.example.amexproject2.repository.UserProfileRepository;
import com.example.amexproject2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserProfileServiceImp implements UserProfileService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserProfileRepository userProfileRepository;


    @Override
    public UserProfile createUserProfile(String username, UserProfile newUserProfile) {
        User userToUpdate = userRepository.findByUsername(username);
        newUserProfile.setUser(userToUpdate);
        userToUpdate.setUserProfile(newUserProfile);
        return userProfileRepository.save(newUserProfile);
    }

    @Override
    public UserProfile getUserProfile(String username) {
        User userProfileToGet = userRepository.findByUsername(username);
        return userProfileToGet.getUserProfile();
    }
}
