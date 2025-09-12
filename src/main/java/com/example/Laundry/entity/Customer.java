package com.example.Laundry.entity;

import jakarta.persistence.*;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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
    private Double phoneNumber;

    @NotBlank(message = "level cannot be null or blank")
    private String level;

    @NotBlank(message = "avatar cannot be null or blank")
    private String avatar;

    @OneToOne(mappedBy = "customer")
    private Account account;

    @OneToMany(mappedBy = "customer")
    private ArrayList<Oder> oder;
}
