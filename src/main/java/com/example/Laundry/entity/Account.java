package com.example.Laundry.entity;

import jakarta.persistence.*;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Entity
@Table
@Data

public class Account {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id

    private Long accountId;

    @NotNull(message = "password cannot be blank")
    private String password;

    @NotNull(message = "active cannot be blank")
    private String active;

    @OneToOne
    @JoinColumn(name = "roleId")
    private Role role;

    @OneToOne
    @JoinColumn(name = "customerId")
    private Customer customer;

    @OneToOne
    @JoinColumn(name = "staffId")
    private Staff staff;
}
