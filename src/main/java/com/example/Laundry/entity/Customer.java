package com.example.Laundry.entity;

import jakarta.persistence.*;
import lombok.Data;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.ArrayList;

@Entity
@Data
@Table
public class Customer {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @NotNull(message = "id cannot be blank")
    private Long customerId;

    @NotBlank(message = "name cannot be null or blank")
    private String name;

    @NotBlank(message = "address cannot be null or blank")
    private String address;

    @Email(message = "Invalid email format")
    private String email;

    @NotBlank(message = "phoneNumber cannot be null or blank")
    private String phoneNumber;

    @NotBlank(message = "level cannot be null or blank")
    private String level;

    @NotBlank(message = "avatar cannot be null or blank")
    private String avatar;

    @OneToOne(mappedBy = "customer")
    private Account account;

    @OneToMany(mappedBy = "customer")
    private ArrayList<Oder> oder;
}
