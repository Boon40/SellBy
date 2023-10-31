package com.sellby.sellby.service;


import com.sellby.sellby.mapper.UserMapper;
import com.sellby.sellby.model.entity.Product;
import com.sellby.sellby.model.entity.User;
import com.sellby.sellby.model.request.UserRequest;
import com.sellby.sellby.model.response.ProductResponse;
import com.sellby.sellby.model.response.UserResponse;
import com.sellby.sellby.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordHasher passwordHasher;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
        this.passwordHasher = new PasswordHasher();
        this.userMapper = new UserMapper();
    }

    public UserResponse registerUser(UserRequest request) throws Exception{
        if (userRepository.findUserByEmail(request.getEmail()) != null){
            System.out.println("throwing exception");
            throw new Exception("Email already is use");
        }
        final var user = userMapper.toEntity(request);
        final var savedUser = userRepository.save(user);

        return userMapper.toResponse(savedUser);
    }

    public void LoginUser(String email, String password) throws Exception{
        User user = userRepository.findUserByEmail(email);
        if (user != null && passwordHasher.CheckHash(user.getPassword_hash(), password)){
            /* TODO Login user*/
            return;
        }
        throw new Exception("Wrong email and/or password");
    }

    public List<UserResponse> getAllUsers(){
        return ((List<User>) userRepository.findAll())
                .stream()
                .map(userMapper::toResponse)
                .toList();
    }
    public User getUserById(int id){
        Optional<User> user = userRepository.findById((long) id);
        return user.orElse(null);
    }

}
