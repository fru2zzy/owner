package com.example.owner.controller;

import java.util.List;

import javax.validation.Valid;

import com.example.owner.CatClient;
import com.example.owner.model.Cat;
import com.example.owner.model.Owner;
import com.example.owner.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@RestController
@RefreshScope
@RequestMapping("/owner")
public class OwnerController {

    private OwnerRepository ownerRepository;
    private CatClient catClient;

    public OwnerController(OwnerRepository ownerRepository, CatClient catClient) {
        this.ownerRepository = ownerRepository;
        this.catClient = catClient;
    }

    @Value("${main.owner.name}")
    private String mainOwner;

    @GetMapping
    public String getOwner() {
        return mainOwner;
    }

    @GetMapping(value = "/list", produces = APPLICATION_JSON)
    public List<Owner> getOwnerList() {
        return ownerRepository.findAll();
    }

    @GetMapping(value = "/cat", produces = APPLICATION_JSON)
    public List<Cat> getCat() {
        return catClient.getCat();
    }

    @GetMapping(value = "/cat/{ids}", produces = APPLICATION_JSON)
    public Cat getCatById(@PathVariable(name = "ids") int id) {
        return catClient.getCatById(id);
    }

    @PostMapping
    public Owner postOwner(@Valid @RequestBody Owner owner) {
        return ownerRepository.save(owner);
    }
}
