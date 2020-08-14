package com.example.owner;

import java.util.List;

import com.example.owner.controller.FallBackController;
import com.example.owner.model.Cat;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@FeignClient(name = "cat-dog", url = "http://cat-dog-denis.herokuapp.com:80", fallback = FallBackController.class)
public interface CatClient {

    @GetMapping("/cat")
    List<Cat> getCat();

    @GetMapping(value = "/cat/{ids}", produces = APPLICATION_JSON_VALUE)
    Cat getCatById(@PathVariable(name = "ids") int id);
}
