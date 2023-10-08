package com.sellby.sellby.services;


import com.sellby.sellby.models.User;
import com.sellby.sellby.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordHasher passwordHasher;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
        this.passwordHasher = new PasswordHasher();
    }

    public void RegisterUser(String email, String number, String first_name, String last_name, String password, String country, String city) throws Exception{
        if (userRepository.findUserByEmail(email) != null){
            System.out.println("throwing exception");
            throw new Exception("Email already is use");
        }
        User newUser = new User(email, number, first_name, last_name, passwordHasher.HashPassword(password), country, city, LocalDate.now());
        userRepository.save(newUser);
    }

    public void LoginUser(String email, String password) throws Exception{
        User user = userRepository.findUserByEmail(email);
        if (user != null && passwordHasher.CheckHash(user.GetPasswordHash(), password)){
            /* TODO Login user*/
            return;
        }
        throw new Exception("Wrong email and/or password");
    }

}
