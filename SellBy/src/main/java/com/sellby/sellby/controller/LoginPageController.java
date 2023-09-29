package com.sellby.sellby.controller;

import com.sellby.sellby.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/")
public class LoginPageController {

    private final UserService userService;

    @Autowired
    public LoginPageController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/login")
    public String LoginPage(){
        return "loginPage";
    }

    /*@PostMapping("/login")
    public String postLoginPage(){
    TODO authentication and current user data
    }*/
}
