package com.sellby.sellby.controller;

import com.sellby.sellby.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @PostMapping("/login")
    public String postLoginPage(
            @RequestParam("email") String email,
            @RequestParam("password") String password,
            Model model
    ){
        try{
            userService.LoginUser(email, password);
        } catch (Exception e){
            model.addAttribute("error", e.getMessage());
            return "loginPage";
        }
        return "mainPage";
    }
}
