package com.example.demo.model;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "requests")
@Data
public class RequestEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String payload;

    private String status;
}

