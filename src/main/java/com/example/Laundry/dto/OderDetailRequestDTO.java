package com.example.Laundry.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OderDetailRequestDTO {

    
    private Long oderDetailId;

    @PositiveOrZero(message = "price must be >= 0")
    private BigDecimal price;

    @PositiveOrZero(message = "amount must be >= 0")
    private BigDecimal amount;

    @NotBlank(message = "specialRequest cannot be blank")
    private String specialRequest;

//    @NotBlank(message = "service not blank or null")
//    private Service service;

    private Long serviceId;
}
