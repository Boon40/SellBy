package com.sellby.sellby.models;

import jakarta.persistence.*;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @Column(length = 1000)
    @Lob
    private String description;
    private float price;
    @ManyToOne
    @JoinColumn(name = "seller_id")
    private User seller;
    @ManyToOne
    @JoinColumn(name = "state_id")
    private State state;
    @OneToMany(mappedBy = "product")
    private List<ProductPhoto> photos = new ArrayList<>();
    @ManyToMany(mappedBy = "favouriteProducts")
    private List<User> users = new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    private boolean isBuyerPayingDelivery;
    private LocalDate createdDate;

    public Product(){}

    public Product(String name, String description, float price, User seller, State state, Category category, boolean isBuyerPayingDelivery, LocalDate createdDate) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.seller = seller;
        this.state = state;
        this.photos = photos;
        this.category = category;
        this.isBuyerPayingDelivery = isBuyerPayingDelivery;
        this.createdDate = createdDate;
    }
    public Product(int id, String name, String description, float price, User seller, State state, Category category, boolean isBuyerPayingDelivery, LocalDate createdDate) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.seller = seller;
        this.state = state;
        this.photos = photos;
        this.category = category;
        this.isBuyerPayingDelivery = isBuyerPayingDelivery;
        this.createdDate = createdDate;
    }

    // GETTERS
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

    public String GetPriceString(){
        DecimalFormat df = new DecimalFormat("0.00");
        return df.format(this.price) + "€";
    }
    public User GetSeller() {
        return this.seller;
    }

    public State GetState() {
        return this.state;
    }

    public List<ProductPhoto> GetPhotos() {
        return this.photos;
    }

    public Category GetCategory(){
        return this.category;
    }

    public boolean GetIsBuyerPayingDelivery(){
        return this.isBuyerPayingDelivery;
    }

    public String GetCreatedDate(){
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd MMMM, yyyy");
        return this.createdDate.format(f);
    }

    // SETTERS
    public void SetPhotos(List<ProductPhoto> photos) {
        this.photos = photos;
    }
}
