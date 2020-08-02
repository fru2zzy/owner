package com.example.owner.controller;

import java.util.List;

import javax.validation.Valid;

import com.example.owner.exception.OwnerNotFoundException;
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

@RestController
@RefreshScope
@RequestMapping("/api/owner")
public class OwnerController {

    private OwnerRepository ownerRepository;

    @Value("${main.owner.name}")
    private String mainOwner;

    public OwnerController(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @GetMapping
    public String getOwner() {
        return mainOwner;
    }

    @GetMapping("/list")
    public List<Owner> getOwnerList() {
        return ownerRepository.findAll();
    }

    @PostMapping
    public Owner postOwner(@Valid @RequestBody Owner owner) {
        return ownerRepository.save(owner);
    }

    @GetMapping("/{ids}")
    public Owner getCatById(@PathVariable(name = "ids") int id) throws OwnerNotFoundException {
        return ownerRepository.findById(id).orElseThrow(() -> new OwnerNotFoundException("Cannot find owner by id = " + id));
    }
}
