package com.example.Laundry.service.implement;


import com.example.Laundry.dto.CustomersRequestDTO;
import com.example.Laundry.dto.CustomersResponseDTO;
import com.example.Laundry.entity.Customer;
import com.example.Laundry.mapper.CustomersMapper;
import com.example.Laundry.repository.CustomersRepository;
import com.example.Laundry.service.CustomersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class CustomersServiceImpl implements CustomersService {

    private final CustomersRepository customerRepository;
    private final CustomersMapper customerMapper;

    @Override
    public CustomersResponseDTO createCustomer(CustomersRequestDTO dto) {
        if(customerRepository.existsByEmail(dto.getEmail())){
            throw new RuntimeException("Email already exists");
        }
        Customer customer = customerMapper.toEntity(dto);
        Customer saved = customerRepository.save(customer);
        return customerMapper.toResponse(saved);
    }

    @Override
    public List<CustomersResponseDTO> getAllCustomers() {
        return customerRepository.findAll()
                .stream()
                .map(customerMapper::toResponse)
                .toList();
    }

    @Override
    public CustomersResponseDTO getCustomerById(Long id) {
        return customerRepository.findById(id)
                .map(customerMapper::toResponse)
                .orElseThrow(() -> new RuntimeException("id not found"));
    }

    @Override
    public CustomersResponseDTO updateCustomer(Long id, CustomersRequestDTO dto) {
        return customerRepository.findById(id)
                .map(customer -> {
                    customer.setName(dto.getName());
                    customer.setPhoneNumber(dto.getPhoneNumber());
                    customer.setAddress(dto.getAddress());
                    customer.setLevel(dto.getLevel());
                    customer.setAvatar(dto.getAvatar());

                    if (!customer.getEmail().equals(dto.getEmail())) {
                        if (customerRepository.existsByEmail(dto.getEmail())) {
                            throw new RuntimeException("email not found");
                        }
                        customer.setEmail(dto.getEmail());
                    }

                    return customerMapper.toResponse(customerRepository.save(customer));
                })
                .orElseThrow(() -> new RuntimeException("customer not found"));
    }

    @Override
    public void deleteCustomer(Long id) {
        customerRepository.findById(id)
                .ifPresentOrElse(
                        customerRepository::delete,
                        () -> { throw new RuntimeException("CustomerId not found");}
                );
    }

    @Override
    public List<CustomersResponseDTO> searchByName(String keyword) {
        return customerRepository.findByNameContainingIgnoreCase(keyword)
                .stream()
                .map(customerMapper::toResponse)
                .toList();
    }
}