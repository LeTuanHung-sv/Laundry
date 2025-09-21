package com.example.Laundry.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class OderHistoryResponsesDTO {
    private Long oderId;

    @Future(message = "Booking date must be in the future")
    private LocalDateTime oderDate;

    @PositiveOrZero(message = "totalAmount cannot be <= 0")
    private BigDecimal totalAmount;

    private String note;
}
