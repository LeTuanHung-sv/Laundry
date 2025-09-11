package com.example.Laundry.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Negative;
import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class OderResourceRequestDTO{
    @NotNull(message = "Id not null")
    private Long resourceId;

    @Negative(message = "allocatedAmount cannot be negative")
    private Integer allocatedAmount;

}
