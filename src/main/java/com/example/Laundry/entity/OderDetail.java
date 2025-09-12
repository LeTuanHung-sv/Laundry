package com.example.Laundry.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Negative;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Table (name = "oder_details")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull(message = "id cannot be blank")
    private Long oderDetailId;

    @Negative(message = "price cannot be negative")
    private BigDecimal price;

    @Negative(message = "price cannot be negative")
    private BigDecimal amount;

    @NotBlank(message = "specialRequest not null")
    private String specialRequest;

    @ManyToOne
    @JoinColumn(name = "oder_id")
    private Oder oder;

    @ManyToOne
    @JoinColumn(name = "service_id", nullable = false)
    private Service service;

}
