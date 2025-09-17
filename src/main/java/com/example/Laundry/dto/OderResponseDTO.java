package com.example.Laundry.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Future;
import javax.validation.constraints.Negative;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class OderResponseDTO {
    private Long id;

    @Future(message = "Booking date must be in the future")
    private Date oderDate;

    @Negative(message = "totalAmount cannot be Negative")
    private BigDecimal totalAmount;

    private String note;

}
