package com.sellby.sellby.repository;

import com.sellby.sellby.models.Product;
import com.sellby.sellby.models.ProductPhoto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductPhotoRepository extends JpaRepository<ProductPhoto, Long> {

    @Query("SELECT pp FROM ProductPhoto pp WHERE pp.product = ?1")
    List<ProductPhoto> findAllPhotosOfProduct(Product product);

}
