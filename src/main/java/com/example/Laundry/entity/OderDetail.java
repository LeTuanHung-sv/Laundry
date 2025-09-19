package com.example.Laundry.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Entity
@Table
@Data
public class OderDetail {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long orderDetailId;
    private BigDecimal price;
    private BigDecimal amount;

    @ManyToOne()
    @JoinColumn(name = "oderId")
    private Oder oder;

    @ManyToOne()
    @JoinColumn(name = "serviceId")
    private Service service;
}
