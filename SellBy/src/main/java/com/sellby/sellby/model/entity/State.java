package com.sellby.sellby.model.entity;

import com.sellby.sellby.model.enums.StateEnum;
import jakarta.persistence.*;

@Entity
public class State {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    @Column(name = "state")
    private StateEnum state;

    public State() {}

    public State(int id, StateEnum state) {
        this.id = id;
        this.state = state;
    }

    public State(int id) {
        this.id = id;
    }

    public int GetId(){
        return this.id;
    }

    public String ToString(){
        return this.state.toString();
    }
}
