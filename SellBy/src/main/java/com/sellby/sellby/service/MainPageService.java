package com.sellby.sellby.service;

import com.sellby.sellby.model.entity.Product;
import com.sellby.sellby.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
