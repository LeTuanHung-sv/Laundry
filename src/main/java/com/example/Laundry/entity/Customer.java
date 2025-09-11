package com.example.Laundry.entity;

import jakarta.persistence.*;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;

@Entity
@Data
@Table
public class Customer {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @NotNull(message = "Id not blank")
    private Long customerId;
    private String name;
    private String address;
    private String email;
    private Double phoneNumber;
    private String level;
    private String avatar;

    @OneToOne(mappedBy = "customer")
    private Account account;

    @OneToMany(mappedBy = "customer")
    private ArrayList<Oder> oder;
}
