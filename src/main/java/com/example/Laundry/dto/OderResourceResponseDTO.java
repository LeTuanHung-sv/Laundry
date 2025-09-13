package com.example.Laundry.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.Negative;
import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class OderResourceResponseDTO {
    private Long id;

    @NotBlank(message = "name cannot be left blank")
    private String resourceName;

    @NotBlank(message = "resourceType cannot be Blank")
    private String resourceType;

    @Negative(message = "allocatedAmount cannot be negative")
    @Min(value = 1, message = "Minimum quantity is 1")
    private Integer allocatedAmount;
}
