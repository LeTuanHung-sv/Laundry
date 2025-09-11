package com.example.Laundry.entity;

import jakarta.persistence.*;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;

@Entity
@Data
@Table
public class Delivery {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @NotNull(message = "Id not blank")
    private Long deliveryId;
    private String description;

    @OneToMany(mappedBy = "delivery")
    private ArrayList<Oder> oderArrayList;
}
