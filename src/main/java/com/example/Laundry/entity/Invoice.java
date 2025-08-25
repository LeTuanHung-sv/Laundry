package com.example.Laundry.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Table
@Data
public class Invoice {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long invoiceId;
    private BigDecimal amount;
    private BigDecimal price;
    private BigDecimal totalPrice;
}
