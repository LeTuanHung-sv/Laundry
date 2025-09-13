package com.example.Laundry.entity;

import jakarta.persistence.*;
import lombok.Data;

import javax.validation.constraints.Negative;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Table
@Data
public class OderDetail {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long orderDetailId;

    @Negative(message = "price cannot be negative")
    private BigDecimal price;

    @Negative(message = "price cannot be negative")
    private BigDecimal amount;

    @NotBlank(message = "specialRequest not null")
    private String specialRequest;


    @ManyToOne()
    @JoinColumn(name = "oderId")
    private Oder oder;

    @ManyToOne()
    @JoinColumn(name = "serviceId")
    private Service service;

}
