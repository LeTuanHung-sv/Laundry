package com.example.Laundry.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    private BigDecimal price;
    private BigDecimal amount;
    private String specialRequest;

    @ManyToOne
    @JoinColumn(name = "oder_id")
    private Oder oder;

    @ManyToOne
    @JoinColumn(name = "service_id", nullable = false)
    private Service service;

}
