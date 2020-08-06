package com.example.owner;

import java.util.List;

import com.example.owner.model.Cat;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "cat-dog", url = "http://localhost:8085")
public interface CatClient {

    @GetMapping("/cat")
    List<Cat> getAll();
}
