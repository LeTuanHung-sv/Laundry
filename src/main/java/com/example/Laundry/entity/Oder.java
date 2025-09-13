package com.example.Laundry.entity;

import jakarta.persistence.*;
import lombok.Data;

import javax.validation.constraints.Future;
import javax.validation.constraints.Negative;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table
@Data
public class Oder {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long oderId;

    @Future(message = "Booking date must be in the future")
    private Date oderDate;

    @Negative(message = "totalAmount cannot be Negative")
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

    @OneToMany(mappedBy = "oder", cascade = CascadeType.ALL)
    private List<OderResource> resources = new ArrayList<>();
}
