package com.example.ecpaymentservice;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "admin")
@Getter
@Setter
public class Admin {
    @Id
    private String key; // Primary Key

    private String value; // Corresponding Value

    // Getters and Setters
}

