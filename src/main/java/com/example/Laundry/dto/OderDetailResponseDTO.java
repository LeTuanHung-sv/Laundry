package com.example.Laundry.dto;

import com.example.Laundry.entity.OderDetail;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Negative;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OderDetailResponseDTO {

    @NotNull(message = "id cannot be blank")
    private Long id;

    @Negative(message = "price cannot be negative")
    private BigDecimal price;

    @Negative(message = "price cannot be negative")
    private BigDecimal amount;

    @NotBlank(message = "specialRequest not null")
    private String specialRequest;
}
