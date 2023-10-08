package com.sellby.sellby.controller;

import com.sellby.sellby.models.User;
import com.sellby.sellby.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/")
public class RegisterPageController {

    private final UserService userService;

    @Autowired
    public RegisterPageController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/register")
    public String RegisterPage(){
        return "registerPage";
    }

    @PostMapping("/register")
    public String RegisterPage(
            @RequestParam("first_name") String firstName,
            @RequestParam("last_name") String lastName,
            @RequestParam("email") String email,
            @RequestParam("number") String number,
            @RequestParam("password") String password,
            @RequestParam("repeat_password") String repeatPassword,
            @RequestParam("country") String country,
            @RequestParam("city") String city,
            Model model
            ){
        if (password.equals(repeatPassword)){
            try{
                userService.RegisterUser(email, number, firstName, lastName, password, country, city);
            } catch(Exception e){
                model.addAttribute("error", e.getMessage());
                return "registerPage";
            }
        }
        else{
            model.addAttribute("error", "Passwords doesn't match");
            return "registerPage";
        }
        return "mainPage";
    }
}
