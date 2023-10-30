package com.sellby.sellby.repository;

import com.sellby.sellby.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("SELECT p FROM Product p LEFT JOIN ProductPhoto pp ON p = pp.product")
    List<Product> GetAllProducts();

    @Query("SELECT p FROM Product p WHERE p.id = ?1")
    Product GetProductById(int id);
}
