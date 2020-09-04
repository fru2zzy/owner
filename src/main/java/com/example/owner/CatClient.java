package com.example.owner;

import java.util.Collections;
import java.util.List;

import com.example.owner.model.Cat;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@FeignClient(name = "cat-dog", url = "http://cat-dog-denis.herokuapp.com:80", fallback = CatClient.FallBackController.class)
public interface CatClient {

    @Component
    class FallBackController implements CatClient {

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

    @GetMapping("/cat")
    List<Cat> getCat();

    @GetMapping(value = "/cat/{ids}", produces = APPLICATION_JSON_VALUE)
    Cat getCatById(@PathVariable(name = "ids") int id);
}
