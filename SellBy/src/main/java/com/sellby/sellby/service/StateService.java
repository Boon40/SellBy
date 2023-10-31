package com.sellby.sellby.service;


import com.sellby.sellby.model.entity.Category;
import com.sellby.sellby.model.entity.State;
import com.sellby.sellby.repository.CategoryRepository;
import com.sellby.sellby.repository.StateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StateService {

    StateRepository stateRepository;

    @Autowired
    StateService(StateRepository stateRepository){
        this.stateRepository = stateRepository;
    }

    public State getStateById(int id){
        Optional<State> state = stateRepository.findById((long) id);
        return state.orElse(null);
    }
}
