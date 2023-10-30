package com.sellby.sellby.model.entity;

import jakarta.persistence.*;

@Entity
public class ProductPhoto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String path;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public ProductPhoto() {}

    public ProductPhoto(String path, Product product) {
        this.path = path;
        this.product = product;
    }

    public ProductPhoto(int id, String path, Product product) {
        this.id = id;
        this.path = path;
        this.product = product;
    }

    public int GetId() {
        return this.id;
    }

    public String GetPath() {
        return this.path;
    }

    public Product GetProduct() {
        return this.product;
    }
}
