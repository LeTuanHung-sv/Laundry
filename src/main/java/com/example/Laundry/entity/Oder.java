package com.example.Laundry.entity;

import com.example.Laundry.OderStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table (name = "orders")
@Data
public class Oder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long oderId;

    private Date oderDate;
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
