package com.example.Laundry.mapper;

import com.example.Laundry.dto.CustomersRequestDTO;
import com.example.Laundry.dto.CustomersResponseDTO;
import com.example.Laundry.entity.Customer;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
public interface CustomersMapper{
    CustomersResponseDTO toResponse(Customer customer);

    Customer toEntity(CustomersRequestDTO dto);
}