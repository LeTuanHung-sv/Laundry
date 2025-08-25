package com.example.Laundry.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table
public class Customer {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long customerId;
    private String name;
    private String address;
    private String email;
    private Double phoneNumber;
    private String level;
    private String avatar;
}
