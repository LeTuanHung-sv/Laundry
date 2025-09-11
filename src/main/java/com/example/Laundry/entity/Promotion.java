package com.example.Laundry.entity;

import jakarta.persistence.*;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table
@Data
public class Promotion {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @NotNull(message = "Id not blank")
    private Long promotionId;
    private String promotionName;
    private String discountRate;
    private Date starDate;
    private Date endDate;
    private String active;

    @ManyToOne
    @JoinColumn(name = "staffId")
    private Staff staff;

    @OneToMany(mappedBy = "promotion")
    private List<Service> services;
}
