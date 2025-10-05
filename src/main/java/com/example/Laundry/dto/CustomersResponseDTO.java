package com.example.Laundry.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class CustomersResponseDTO {

    private Long customerId;

    @NotBlank(message = "name cannot be null or blank")
    private String name;

    @NotBlank(message = "address cannot be null or blank")
    private String address;

    @Email(message = "Invalid email format")
    private String email;

    @NotBlank(message = "phoneNumber cannot be null or blank")
    private String phoneNumber;

    @NotBlank(message = "level cannot be null or blank")
    private String level;

    @NotBlank(message = "avatar cannot be null or blank")
    private String avatar;

}