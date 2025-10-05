package com.example.Laundry.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import javax.validation.constraints.Future;
import javax.validation.constraints.PositiveOrZero;


@Entity
@Table
@Data
public class Oder {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long oderId;

    @Future(message = "Booking date must be in the future")
    private LocalDateTime oderDate;

    @PositiveOrZero(message = "totalAmount cannot be <= 0")
    private BigDecimal totalAmount;

    private String note;

    @OneToMany(mappedBy = "oder")
    private List<OderDetail> oderDetailList = new ArrayList<>();

    @ManyToOne()
    @JoinColumn(name = "customerId")
    private Customer customer;

    @OneToOne(mappedBy = "oder")
    private Invoice invoice;

    @ManyToOne()
    @JoinColumn(name = "deliveryId")
    private Delivery delivery;
}
