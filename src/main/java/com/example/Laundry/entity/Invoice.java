package com.example.Laundry.entity;

import jakarta.persistence.*;
import lombok.Data;

import javax.validation.constraints.Negative;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Table
@Data
public class Invoice {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @NotNull(message = "id cannot be blank")
    private Long invoiceId;

    @Negative(message = "amount cannot be negative")
    private BigDecimal amount;

    @Negative(message = "price cannot be negative")
    private BigDecimal price;

    @Negative(message = "totalPrice cannot be negative")
    private BigDecimal totalPrice;

    @OneToOne()
    @JoinColumn(name = "oderId")
    private Oder oder;
}
