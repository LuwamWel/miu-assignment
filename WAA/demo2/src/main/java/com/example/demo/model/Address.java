package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="address_id")
    private Long id;
    private String city;
    private String state;
    private String zipcode;

    @JsonManagedReference
    @OneToMany(mappedBy ="address")
    private List<Student> students;

}
