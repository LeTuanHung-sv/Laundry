package com.example.Laundry.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table
public class Role {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long roleId;
    private String roleName;

    @OneToOne(mappedBy = "role")
    private Account account;
}
