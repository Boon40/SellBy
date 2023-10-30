package com.sellby.sellby.model.entity;

import com.sellby.sellby.model.enums.CategoryEnum;
import jakarta.persistence.*;

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

    public String ToString(){
        return this.category.toString();
    }
}
