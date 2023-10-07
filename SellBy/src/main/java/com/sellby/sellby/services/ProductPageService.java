package com.sellby.sellby.services;


import com.sellby.sellby.models.Product;
import com.sellby.sellby.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductPageService {
    private final ProductRepository productRepository;

    @Autowired
    ProductPageService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public Product GetProductById(int id){
        return productRepository.GetProductById(id);
    }
}
