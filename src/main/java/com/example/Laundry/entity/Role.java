package com.example.Laundry.entity;

import jakarta.persistence.*;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@Entity
@Table
public class Role {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @NotNull(message = "id cannot blank")
    private Long roleId;
    private String roleName;

    @OneToOne(mappedBy = "role")
    private Account account;
}
