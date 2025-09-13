package com.example.Laundry.entity;

import jakarta.persistence.*;
import lombok.Data;

import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table
@Data
public class Promotion {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long promotionId;

    @NotBlank(message = "name cannot be blank")
    private String promotionName;

    private String discountRate;

    @Future(message = "Booking date must be in the future")
    private Date starDate;

    @Past(message = "not Past")
    private Date endDate;

    @NotBlank(message = "active cannot be blank")
    private String active;

    @ManyToOne
    @JoinColumn(name = "staffId")
    private Staff staff;

    @OneToMany(mappedBy = "promotion")
    private List<Service> services;
}
