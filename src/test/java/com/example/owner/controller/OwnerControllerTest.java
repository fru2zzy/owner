package com.example.owner.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.owner.model.Owner;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class OwnerControllerTest {

    ObjectMapper mapper = new ObjectMapper();

    @Autowired
    OwnerController ownerController;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void getOwner() {
        ResponseEntity<Owner[]> responseEntity = restTemplate.getForEntity("http://localhost:" + port + "/api/owner", Owner[].class);
        assertNotNull(responseEntity);
        Owner[] owners = responseEntity.getBody();
        assertTrue(owners.length == 3);
    }

    @Test
    void getOwnerById() {
        ResponseEntity<Owner> responseEntity = restTemplate.getForEntity("http://localhost:" + port + "/api/owner/2", Owner.class);
        assertNotNull(responseEntity);
        Owner owner = responseEntity.getBody();
        assertEquals("Andy", owner.getName());
    }

    @Test
    void getOwnerById404() {
        ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://localhost:" + port + "/api/owner/100", String.class);
        assertNotNull(responseEntity);
        String body = responseEntity.getBody();
        assertEquals("Cannot return an owner with index 100 because owner list size = 3", body);
    }

    @Test
    void postNotValidOwner() throws JsonProcessingException {
//        Owner owner = new Owner(444, "", "Uzhgorod");
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//
//        Map<String, Object> errors = new HashMap<>();
//        errors.put("timeStamp", new Date().toString());
//        errors.put("status", "method 'postOwner' parameter 0");
//        List<String> errorsList = new ArrayList<>();
//        errorsList.add("Age should not be greater than 100");
//        errorsList.add("Name can't be blank");
//        errors.put("errorsList", errorsList);
//        String expectedResponseMessage = "{timeStamp=" + new Date().toString() +
//                ", errorsList=[Age should not be greater than 100, Name can't be blank], status=method 'postOwner' parameter 0}";
//
//        String catString = mapper.writeValueAsString(owner);
//        HttpEntity<String> httpEntity = new HttpEntity<>(catString, headers);
//        ResponseEntity<Object> responseEntity = this.restTemplate.postForEntity("http://localhost:" + port + "/api/owner", httpEntity, Object.class);
//        assertEquals(expectedResponseMessage, responseEntity.getBody().toString());
//        assertEquals(responseEntity.getStatusCode(), HttpStatus.NOT_FOUND);
    }

    @Test
    void postOwner() throws JsonProcessingException {
//        Owner owner = new Owner(33, "Alex", "Lviv");
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        String body = mapper.writeValueAsString(owner);
//        HttpEntity<String> httpEntity = new HttpEntity<>(body, headers);
//
//        ResponseEntity<Owner> responseEntity = this.restTemplate.postForEntity("http://localhost:" + port + "/api/owner", httpEntity, Owner.class);
//        assertEquals(owner, responseEntity.getBody());
//        assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
    }
}
