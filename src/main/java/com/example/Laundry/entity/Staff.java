package com.example.Laundry.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table
@Data
public class Staff {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long staffId;
    private String staffName;
    private String position;
    private String email;
    private Double phoneNumber;
    private String avatar;
    private String active;
}
