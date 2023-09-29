package com.sellby.sellby.services;


import com.sellby.sellby.models.User;
import com.sellby.sellby.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordHasher passwordHasher;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
        this.passwordHasher = new PasswordHasher();
    }

    public User RegisterUser(String email, String number, String first_name, String last_name, String password){
        /* TODO check for already existing one */
        User newUser = new User(email, number, first_name, last_name, passwordHasher.HashPassword(password));
        return userRepository.save(newUser);
    }

}
