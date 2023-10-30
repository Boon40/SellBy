package com.sellby.sellby.model.response;

import com.sellby.sellby.model.entity.Comment;
import com.sellby.sellby.model.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class UserResponse {
    private int id;
    private String email;
    private String number;
    private String first_name;
    private String last_name;
    private String password_hash;
    private List<Product> products = new ArrayList<>();
    private List<Comment> sendComments = new ArrayList<>();
    private List<Comment> receivedComments = new ArrayList<>();
    private List<Product> favouriteProducts = new ArrayList<>();
    private String country;
    private String city;
    private String createdDate;
}
