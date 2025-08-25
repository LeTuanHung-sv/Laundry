package com.example.Laundry.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table
public class Delivery {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long deliveryId;
    private String description;

}
