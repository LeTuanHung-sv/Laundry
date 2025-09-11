package com.example.Laundry.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Future;
import javax.validation.constraints.Negative;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OderDetailRequestDTO {

    @NotNull(message = "khong trong or rong")
    private Long oderDetailId;

    @Negative(message = "khong am")
    private BigDecimal price;

    @Negative(message = "khong am")
    private BigDecimal amount;
    private String specialRequest;
}
