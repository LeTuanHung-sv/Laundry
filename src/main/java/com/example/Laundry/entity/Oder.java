package com.example.Laundry.entity;

import com.example.Laundry.OderStatus;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Negative;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table (name = "orders")
@Data
@Builder
public class Oder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long oderId;

    @Future(message = "Booking date must be in the future")
    private LocalDateTime oderDate;

    @PositiveOrZero(message = "totalAmount cannot be <= 0")
    private BigDecimal totalAmount;
    private String note;

    @Enumerated(EnumType.STRING)
    private OderStatus status = OderStatus.CREATE;

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

    private List<OderStatusHistory> oderStatusHistories = new ArrayList<>();
}
