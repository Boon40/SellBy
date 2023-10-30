package com.sellby.sellby.mapper;

import com.sellby.sellby.model.entity.Comment;
import com.sellby.sellby.model.entity.Product;
import com.sellby.sellby.model.entity.User;
import com.sellby.sellby.model.request.UserRequest;
import com.sellby.sellby.model.response.UserResponse;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserMapper {
    public UserResponse toResponse(User user){
        return new UserResponse(
            user.GetId(),
            user.GetEmail(),
            user.GetNumber(),
            user.GetFirstName(),
            user.GetLastName(),
            user.GetPasswordHash(),
            user.GetProducts(),
            user.GetSendComments(),
            user.GetReceivedComments(),
            user.GetFavouriteProducts(),
            user.GetCountry(),
            user.GetCity(),
            user.GetCreatedDate()
        );
    }

    public User toEntity(UserRequest request){
        return new User(
            request.getEmail(),
            request.getNumber(),
            request.getFirst_name(),
            request.getLast_name(),
            request.getPassword_hash(),
            request.getCountry(),
            request.getCity(),
            request.getCreatedDate()
        );
    }
}
