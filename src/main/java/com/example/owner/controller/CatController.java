package com.example.owner.controller;

import java.util.List;

import com.example.owner.CatClient;
import com.example.owner.model.Cat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CatController {

    @Autowired
    CatClient catClient;

    public List<Cat> getAll() {
        return catClient.getAll();
    }
}
