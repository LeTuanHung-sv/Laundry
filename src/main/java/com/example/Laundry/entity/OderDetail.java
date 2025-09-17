package com.example.Laundry.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;

@Entity
@Table (name = "oder_details")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long oderDetailId;

    @Min(value = 0,message = "price cannot be negative")
    private BigDecimal price;

    @Min(value = 0,message = "amount cannot be negative")
    private BigDecimal amount;

    @NotBlank(message = "specialRequest not null")
    private String specialRequest;

    @ManyToOne
    @JoinColumn(name = "oder_id")
    private Oder oder;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "service_id")
    private ServiceEntity service;

}
