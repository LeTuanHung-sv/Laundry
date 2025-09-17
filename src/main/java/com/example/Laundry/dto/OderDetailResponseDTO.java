package com.example.Laundry.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.Negative;
import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OderDetailResponseDTO {

    private Long id;

    @Negative(message = "price cannot be negative")
    private BigDecimal price;

    @Negative(message = "price cannot be negative")
    private BigDecimal amount;

    @NotBlank(message = "specialRequest not null")
    private String specialRequest;

//    @NotBlank(message = "service not blank or null")
//    private Service service;
}
