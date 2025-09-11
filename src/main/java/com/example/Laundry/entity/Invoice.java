package com.example.Laundry.entity;

import jakarta.persistence.*;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Table
@Data
public class Invoice {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @NotNull(message = "Id not blank")
    private Long invoiceId;
    private BigDecimal amount;
    private BigDecimal price;
    private BigDecimal totalPrice;

    @OneToOne()
    @JoinColumn(name = "oderId")
    private Oder oder;
}
