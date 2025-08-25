package com.example.Laundry.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
@Table

public class Service {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long serviceId;
    private String serviceName;
    private String description;
    private BigDecimal price;

}
