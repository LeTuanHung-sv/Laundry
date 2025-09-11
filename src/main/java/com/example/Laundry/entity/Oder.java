package com.example.Laundry.entity;

import com.example.Laundry.OderStatus;
import jakarta.persistence.*;
import lombok.Data;

import javax.validation.constraints.NotNull;
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
    @NotNull(message = "id cannot blank")
    private Long oderId;

    private Date oderDate;
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

    @OneToMany(mappedBy = "oder", cascade = CascadeType.ALL)
    private List<OderStatusHistory> oderStatusHistories = new ArrayList<>();
}
