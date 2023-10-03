package com.sellby.sellby.models;

import com.sellby.sellby.services.ProductService;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    private float price;
    @ManyToOne
    @JoinColumn(name = "seller_id")
    private User seller;
    @Enumerated(EnumType.STRING)
    private ProductState state;
    @OneToMany(mappedBy = "product")
    private List<ProductPhoto> photos = new ArrayList<>();
    @ManyToMany(mappedBy = "favouriteProducts")
    private List<User> users = new ArrayList<>();

    public Product(){}

    public Product(String name, String description, float price, User seller, ProductState state) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.seller = seller;
        this.state = state;
        this.photos = photos;
    }
    public Product(int id, String name, String description, float price, User seller, ProductState state) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.seller = seller;
        this.state = state;
        this.photos = photos;
    }

    public int GetId(){
        return this.id;
    }

    public String GetName(){
        return this.name;
    }

    public String GetDescription(){
        return this.description;
    }

    public float GetPrice(){
        return this.price;
    }
    public User GetSeller() {
        return this.seller;
    }

    public ProductState GetState() {
        return this.state;
    }

    public List<ProductPhoto> GetPhotos() {
        return this.photos;
    }

    public void SetPhotos(List<ProductPhoto> photos) {
        this.photos = photos;
    }
}
