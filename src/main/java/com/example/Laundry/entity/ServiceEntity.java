package com.example.Laundry.entity;

import jakarta.persistence.*;
import lombok.Data;

import javax.validation.constraints.Negative;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table

public class ServiceEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long serviceId;

    @NotBlank(message = "name cannot be blank")
    private String serviceName;

    @NotBlank(message = "description cannot be blank")
    private String description;

    @Negative(message = "price cannot be negative")
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
