package com.example.Laundry.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;

@Entity
@Data
@Table
public class Delivery {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long deliveryId;
    private String description;

    @OneToMany(mappedBy = "delivery")
    private ArrayList<Oder> oderArrayList;
}
