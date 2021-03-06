package com.example.owner.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Min(value = 5, message = "Age should be greater than 5")
    @Max(value = 100, message = "Age should not be greater than 100")
    private int age;

    @NotBlank(message = "Name can't be blank")
    private String name;

    @NotBlank(message = "Address can't be blank")
    private String address;
}
