package com.sellby.sellby.models;

public class Product {
    private int id;
    private String name;
    private String description;
    private float price;

    public Product(int id, String name, String description, float price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
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

}
