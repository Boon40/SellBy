package com.sellby.sellby.models;

import jakarta.persistence.*;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int rating;
    private String description;
    @ManyToOne
    @JoinColumn(name = "sender_id")
    private User sender;

    @ManyToOne
    @JoinColumn(name = "receiver_id")
    private User receiver;

    public Comment() {}

    public Comment(int rating, String description, User sender, User receiver) {
        this.rating = rating;
        this.description = description;
        this.sender = sender;
        this.receiver = receiver;
    }

    public Comment(int id, int rating, String description, User sender, User receiver) {
        this.id = id;
        this.rating = rating;
        this.description = description;
        this.sender = sender;
        this.receiver = receiver;
    }

    public int GetId() {
        return this.id;
    }

    public int GetRating() {
        return this.rating;
    }

    public String GetDescription() {
        return this.description;
    }

    public User GetSender() {
        return this.sender;
    }

    public User GetReceiver() {
        return this.receiver;
    }
}
