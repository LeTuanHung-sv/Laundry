package com.example.Laundry.entity;

import jakarta.persistence.*;
import lombok.Data;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.ArrayList;

@Entity
@Data
@Table
public class Delivery {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @NotNull(message = "id cannot be blank")
    private Long deliveryId;

    @NotBlank(message = "description cannot be null or blank")
    private String description;

    @OneToMany(mappedBy = "delivery")
    private ArrayList<Oder> oderArrayList;
}
