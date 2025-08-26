package com.example.Laundry.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;

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

    @OneToMany(mappedBy = "staff")
    private ArrayList<Promotion> promotion;

    @OneToMany(mappedBy = "staff")
    private ArrayList<Service> services;

    @OneToOne(mappedBy = "staff")
    private Account account;

}
