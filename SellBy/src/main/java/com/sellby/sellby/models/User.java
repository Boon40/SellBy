package com.sellby.sellby.models;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String email;
    private String number;
    private String first_name;
    private String last_name;
    private String password_hash;
    @OneToMany(mappedBy = "seller")
    private List<Product> products = new ArrayList<>();
    @OneToMany(mappedBy = "sender")
    private List<Comment> sendComments = new ArrayList<>();
    @OneToMany(mappedBy = "receiver")
    private List<Comment> receivedComments = new ArrayList<>();
    @ManyToMany
    @JoinTable(
            name = "favourite_products",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> favouriteProducts = new ArrayList<>();
    private String country;
    private String city;

    public User(){}

    public User(int id, String email, String number, String first_name, String last_name, String password_hash, String country, String city) {
        this.id = id;
        this.email = email;
        this.number = number;
        this.first_name = first_name;
        this.last_name = last_name;
        this.password_hash = password_hash;
        this.country = country;
        this.city = city;
    }

    public User(String email, String number, String first_name, String last_name, String password_hash, String country, String city) {
        this.email = email;
        this.number = number;
        this.first_name = first_name;
        this.last_name = last_name;
        this.password_hash = password_hash;
        this.country = country;
    }

    //TODO date when created

    public String GetEmail(){
        return this.email;
    }

    public String GetNumber(){
        return this.number;
    }

    public String GetFirstName(){
        return this.first_name;
    }

    public String GetLastName(){
        return this.last_name;
    }

    public String GetPasswordHash(){
        return this.password_hash;
    }

    public List<Product> GetProducts() {
        return this.products;
    }

    public List<Comment> GetSendComments() {
        return sendComments;
    }

    public List<Comment> GetReceivedComments() {
        return receivedComments;
    }

    public List<Product> GetFavouriteProducts() {
        return this.favouriteProducts;
    }

    public String GetNames(){
        return this.first_name + " " + this.last_name;
    }

    public String GetCountry(){
        return this.country;
    }

    public String GetCity(){
        return this.city;
    }

    public String GetCityAndCountry(){
        return this.city + ',' + ' ' + this.country;
    }

    public void SetProducts(List<Product> products) {
        this.products = products;
    }

    public void SetSendComments(List<Comment> sendComments) {
        this.sendComments = sendComments;
    }

    public void SetReceivedComments(List<Comment> receivedComments) {
        this.receivedComments = receivedComments;
    }

    public void SetFavouriteProducts(List<Product> favouriteProducts) {
        this.favouriteProducts = favouriteProducts;
    }
}
