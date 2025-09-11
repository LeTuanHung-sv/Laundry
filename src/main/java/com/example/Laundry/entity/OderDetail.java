package com.example.Laundry.entity;

import jakarta.persistence.*;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Table
@Data
public class OderDetail {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @NotNull(message = "Id not blank")
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
