package com.example.Laundry.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table
@Data

public class Account {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long accountId;
    private String password;
    private String active;
}
