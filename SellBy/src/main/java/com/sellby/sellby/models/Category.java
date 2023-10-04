package com.sellby.sellby.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    @Column(name = "category")
    private CategoryEnum category;

    public Category() {}

    public Category(int id, CategoryEnum category) {
        this.id = id;
        this.category = category;
    }

    public Category(int id) {
        this.id = id;
    }

    public int GetId(){
        return this.id;
    }

    public CategoryEnum GetCategory(){
        return this.category;
    }
}
