package com.sellby.sellby.mapper;

import com.sellby.sellby.model.entity.*;
import com.sellby.sellby.model.response.ProductResponse;
import org.springframework.stereotype.Component;
import com.sellby.sellby.model.request.ProductRequest;



@Component
public class ProductMapper {
    public ProductResponse toResponse(Product product){
        return new ProductResponse(
            product.getId(),
            product.getName(),
            product.getDescription(),
            product.getPrice(),
            product.getSeller(),
            product.getState(),
            product.getPhotos(),
            product.getCategory(),
            product.getIsBuyerPayingDelivery(),
            product.getCreatedDate()
        );
    }

    public Product toEntity(ProductRequest request){
        return Product.builder()
                .name(request.getName())
                .description(request.getDescription())
                .price(request.getPrice())
                .seller(request.getSeller())
                .state(request.getState())
                .photos(request.getPhotos())
                .category(request.getCategory())
                .isBuyerPayingDelivery(request.GetIsBuyerPayingDelivery())
                .createdDate(request.getCreatedDate())
                .build();
    }
}

