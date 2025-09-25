package com.example.Laundry.service;

import com.example.Laundry.dto.CustomersRequestDTO;
import com.example.Laundry.dto.CustomersResponseDTO;

import java.util.List;

public interface CustomersService {
    public CustomersResponseDTO createCustomer(CustomersRequestDTO dto);
    public List<CustomersResponseDTO> getAllCustomers();
    public CustomersResponseDTO getCustomerById(Long id);
    public CustomersResponseDTO updateCustomer(Long id, CustomersRequestDTO dto);
    public void deleteCustomer(Long id);
    public List<CustomersResponseDTO> searchByName(String keyword);
}

