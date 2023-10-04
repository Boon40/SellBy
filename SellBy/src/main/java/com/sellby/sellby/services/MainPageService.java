package com.sellby.sellby.services;

import com.sellby.sellby.models.Product;
import com.sellby.sellby.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MainPageService {
    private final ProductRepository productRepository;

    @Autowired
    public MainPageService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public List<Product> GetLast6Products(){
        List<Product> products = productRepository.GetAllProducts();
        return products.subList(products.size() - 6, products.size());
    }

}
