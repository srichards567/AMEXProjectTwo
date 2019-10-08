package com.example.amexproject2.controller;

import com.example.amexproject2.config.IAuthenticationFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component
public class SecurityController {

    // This is to get the current user in the bean.
    @Autowired
    private IAuthenticationFacade authenticationFacade;


    public String getCurrentUsername() {
        Authentication authentication = authenticationFacade.getAuthentication();
        return authentication.getName();
    }
}
