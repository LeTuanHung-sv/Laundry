package com.example.Laundry.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table
@Data
public class Oder {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long oderId;
    private Date oderDate;
    private BigDecimal totalAmount;
    private String note;

}
