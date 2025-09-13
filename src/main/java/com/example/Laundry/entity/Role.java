package com.example.Laundry.entity;

import jakarta.persistence.*;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table
public class Role {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long roleId;

    @NotBlank(message = "name cannot be blank")
    private String roleName;

    @OneToOne(mappedBy = "role")
    private Account account;
}
