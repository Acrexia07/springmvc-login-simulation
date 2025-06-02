package com.marlonb.springmvc_login_simulation.controller;

import com.marlonb.springmvc_login_simulation.service.LoginAuthenticationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    private final LoginAuthenticationService loginAuthenticationService;

    public LoginController (LoginAuthenticationService loginAuthenticationService) {
        super();
        this.loginAuthenticationService = loginAuthenticationService;
    }

    // Acquire Query Parameter (GET) & and not visible upon retrieval (POST)
    @RequestMapping(value="login", method = RequestMethod.GET)
    public String loginPage () {
        return "login";
    }

    // Pass the retrieved data (POST) to put (PUT) it in the other page (Welcome Page)
    @RequestMapping(value="login", method = RequestMethod.POST)
    public String welcomePage(@RequestParam String name,
                              @RequestParam String password,
                              ModelMap model){
        if (loginAuthenticationService.validateCredentials(name, password)) {

            model.put ("name", name);
            return "welcome";

        }

        model.put ("errorMessage", "Invalid username or password! Please try again.");
        return "login";
    }
}
