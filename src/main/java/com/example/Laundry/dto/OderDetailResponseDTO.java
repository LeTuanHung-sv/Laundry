package com.example.Laundry.dto;

import com.example.Laundry.entity.OderDetail;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OderDetailResponseDTO {
    private Long id;
    private BigDecimal price;
    private BigDecimal amount;
    private String specialRequest;
}
