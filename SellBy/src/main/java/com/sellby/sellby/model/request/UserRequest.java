package com.sellby.sellby.model.request;

import com.sellby.sellby.model.entity.Comment;
import com.sellby.sellby.model.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {
    @NotBlank(message = "Email is required")
    private String email;

    @NotBlank(message = "Number is required")
    private String number;

    @NotBlank(message = "First name is required")
    private String first_name;

    @NotBlank(message = "Last name is required")
    private String last_name;

    @NotBlank(message = "Password hash is required")
    private String password_hash;

    @NotEmpty(message = "Products are required")
    private List<Product> products = new ArrayList<>();

    @NotEmpty(message = "Sent comments are required")
    private List<Comment> sendComments = new ArrayList<>();

    @NotEmpty(message = "Received comment are required")
    private List<Comment> receivedComments = new ArrayList<>();

    @NotEmpty(message = "Favourite products are required")
    private List<Product> favouriteProducts = new ArrayList<>();

    @NotBlank(message = "Country is required")
    private String country;

    @NotBlank(message = "City is required")
    private String city;

    //TODO might be date/datetime also have to change it in entity, response and mapper
    @NotBlank(message = "Created date is required")
    private String createdDate;
}
