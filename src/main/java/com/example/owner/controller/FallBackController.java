package com.example.owner.controller;

import java.util.Collections;
import java.util.List;

import com.example.owner.CatClient;
import com.example.owner.model.Cat;


public class FallBackController implements CatClient {

    private final Cat emptyCat = new Cat(0, "empty cat");

    @Override
    public List<Cat> getCat() {
        return Collections.singletonList(emptyCat);
    }

    @Override
    public Cat getCatById(int id) {
        return emptyCat;
    }
}
