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

    public List<Product> GetTopRowProducts(){
        List<Product> returnProducts = new ArrayList<>();
        List<Product> products = productRepository.GetAllProducts();
        //TODO algorythm for last products
        returnProducts.add(products.get(0));
        returnProducts.add(products.get(1));
        returnProducts.add(products.get(2));
        return returnProducts;
    }

    public List<Product> GetBottomRowProducts(){
        List<Product> returnProducts = new ArrayList<>();
        List<Product> products = productRepository.GetAllProducts();
        returnProducts.add(products.get(3));
        returnProducts.add(products.get(4));
        returnProducts.add(products.get(5));
        return returnProducts;
    }
}
