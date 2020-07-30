package com.example.owner.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import com.example.owner.exception.OwnerNotFoundException;
import com.example.owner.model.Owner;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/owner")
public class OwnerController {
    List<Owner> ownerList = new ArrayList<>();

    public OwnerController() {
        ownerList.add(new Owner(20, "Alex", "Moscow"));
        ownerList.add(new Owner(44, "Max", "Tagil"));
        ownerList.add(new Owner(20, "Andy", "Kyiv"));
    }

    @GetMapping
    public List<Owner> getOwner() {
        return ownerList;
    }

    @PostMapping
    public Owner postOwner(@Valid @RequestBody Owner owner) {
        ownerList.add(owner);
        return owner;
    }

    @GetMapping("/{ids}")
    public Owner getCatById(@PathVariable(name = "ids") int id) throws OwnerNotFoundException {
        int ownerListSize = ownerList.size();
        if (ownerListSize > id) {
            return ownerList.get(id);
        } else {
            throw new OwnerNotFoundException("Cannot return an owner with index " + id + " because owner list size = " + ownerListSize);
        }
    }
}
