package com.marlonb.springmvc_login_simulation.service;

import org.springframework.stereotype.Service;

@Service
public class LoginAuthenticationService {

    public boolean validateCredentials (String username, String password) {

        boolean isUsernameValid = username.equalsIgnoreCase("marlon07");

        boolean isPasswordValid = password.equalsIgnoreCase("pass123");

        return isUsernameValid && isPasswordValid;
    }
}
