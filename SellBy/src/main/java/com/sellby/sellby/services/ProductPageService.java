package com.sellby.sellby.services;


import com.sellby.sellby.models.Comment;
import com.sellby.sellby.models.Product;
import com.sellby.sellby.models.User;
import com.sellby.sellby.repository.CommentRepository;
import com.sellby.sellby.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.List;

@Service
public class ProductPageService {
    private final ProductRepository productRepository;
    private final CommentRepository commentRepository;

    @Autowired
    ProductPageService(ProductRepository productRepository, CommentRepository commentRepository){
        this.productRepository = productRepository;
        this.commentRepository = commentRepository;
    }

    public Product GetProductById(int id){
        return productRepository.GetProductById(id);
    }

    public float GetAverageUserRating(User user){
        List<Comment> allComments = commentRepository.GetAllUserComments(user);
        if (allComments.isEmpty()){
            return -1;
        }
        float averageRating = 0;
        for (Comment currentComment : allComments) {
            averageRating += currentComment.GetRating();
        }

        return averageRating/allComments.size();
    }

    public int GetCommentsCount(User user){
        return commentRepository.GetAllUserComments(user).size();
    }
}
