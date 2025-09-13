package com.example.Laundry.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Negative;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class OderResource {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Negative(message = "allocatedAmount cannot be negative")
    private Integer allocatedAmount;

    @ManyToOne
    private Oder oder;

    @ManyToOne
    private Resource resource;

}
