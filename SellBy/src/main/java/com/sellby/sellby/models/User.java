package com.sellby.sellby.models;

public class User {
    private String email;
    private String number;
    private String first_name;
    private String last_name;

    public User(String email, String number, String first_name, String last_name) {
        this.email = email;
        this.number = number;
        this.first_name = first_name;
        this.last_name = last_name;
    }

    public String email(){
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
}
