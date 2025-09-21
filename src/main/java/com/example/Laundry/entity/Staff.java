package com.example.Laundry.entity;

import jakarta.persistence.*;
import lombok.Data;
import javax.validation.constraints.*;

import java.util.ArrayList;

@Entity
@Table
@Data
public class Staff {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long staffId;

    @NotBlank(message = "name cannot be blank")
    private String staffName;

    @NotBlank(message = "position cannot be blank")
    private String position;

    @Email(message = "Invalid email format")
    private String email;

    @NotBlank(message = "phoneNumber cannot be blank")
    private Double phoneNumber;

    @NotBlank(message = "avatar cannot be blank")
    private String avatar;

    @NotBlank(message = "active cannot be blank")
    private String active;

    @OneToMany(mappedBy = "staff")
    private ArrayList<Promotion> promotion;

    @OneToMany(mappedBy = "staff")
    private ArrayList<ServiceEntity> services;

    @OneToOne(mappedBy = "staff")
    private Account account;

}
