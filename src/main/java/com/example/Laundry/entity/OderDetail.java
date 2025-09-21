package com.example.Laundry.entity;

import jakarta.persistence.*;
import lombok.Data;
import javax.validation.constraints.*;

import java.math.BigDecimal;

@Entity
@Table
@Data
public class OderDetail {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long orderDetailId;

    @Min(value = 0,message = "price cannot be negative")
    private BigDecimal price;

    @Min(value = 0,message = "amount cannot be negative")
    private BigDecimal amount;

    @NotBlank(message = "specialRequest not null")
    private String specialRequest;

    @ManyToOne()
    @JoinColumn(name = "oderId")
    private Oder oder;

    @ManyToOne()
    @JoinColumn(name = "serviceId")
    private ServiceEntity service;
}
