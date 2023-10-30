package com.sellby.sellby.service;

import com.sellby.sellby.mapper.ProductMapper;
import com.sellby.sellby.model.entity.Product;
import com.sellby.sellby.model.request.ProductRequest;
import com.sellby.sellby.model.response.ProductResponse;
import com.sellby.sellby.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public List<ProductResponse> getAllProducts(){
        return((List<Product>) productRepository.findAll())
                .stream()
                .map(productMapper::toResponse)
                .toList();
    }

    public ProductResponse addProduct(ProductRequest request){
        request.setCreatedDate(LocalDate.now());
        final var product = productMapper.toEntity(request);
        final var savedProduct = productRepository.save(product);

        return productMapper.toResponse(savedProduct);
    }

    public void deleteProduct(int id){
        productRepository.deleteById((long)id);
    }
}
