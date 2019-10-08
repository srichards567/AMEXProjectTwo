package com.example.amexproject2.service;

import com.example.amexproject2.controller.SecurityController;
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

    @Autowired
    SecurityController securityController;


    @Override
    public UserProfile createUserProfile(UserProfile newUserProfile) {
        User userToUpdate = userRepository.findByUsername(securityController.getCurrentUsername());
        newUserProfile.setUser(userToUpdate);
        userToUpdate.setUserProfile(newUserProfile);
        return userProfileRepository.save(newUserProfile);
    }

    @Override
    public UserProfile getUserProfile() {
        User userProfileToGet = userRepository.findByUsername(securityController.getCurrentUsername());
        return userProfileToGet.getUserProfile();
    }
}
