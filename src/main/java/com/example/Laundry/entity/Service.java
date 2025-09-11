package com.example.Laundry.entity;

import jakarta.persistence.*;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table

public class Service {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @NotNull(message = "id cannot blank")
    private Long serviceId;
    private String serviceName;
    private String description;
    private BigDecimal price;
    @OneToMany(mappedBy = "service")
    private List<OderDetail> oderDetailList = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "staffId")
    private Staff staff;

    @ManyToOne
    @JoinColumn(name = "promotionId")
    private Promotion promotion;

}
