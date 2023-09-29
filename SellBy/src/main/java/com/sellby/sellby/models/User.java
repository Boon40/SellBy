package com.sellby.sellby.models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

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

    public User(){}
    public User(String email, String number, String first_name, String last_name, String password_hash) {
        this.email = email;
        this.number = number;
        this.first_name = first_name;
        this.last_name = last_name;
        this.password_hash = password_hash;
    }

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
}
