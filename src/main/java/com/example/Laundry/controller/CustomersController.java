package com.example.Laundry.controller;

import com.example.Laundry.dto.CustomersRequestDTO;
import com.example.Laundry.dto.CustomersResponseDTO;
import com.example.Laundry.service.CustomersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor

public class CustomersController {
    private final CustomersService customerService;

    @PostMapping("/create/customers")
    public ResponseEntity<CustomersResponseDTO> createCustomer(@Valid @RequestBody CustomersRequestDTO dto) {
        return ResponseEntity.ok(customerService.createCustomer(dto));
    }

    @GetMapping
    public ResponseEntity<List<CustomersResponseDTO>> getAllCustomers() {
        return ResponseEntity.ok(customerService.getAllCustomers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomersResponseDTO> getCustomerById(@PathVariable Long id) {
        return ResponseEntity.ok(customerService.getCustomerById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomersResponseDTO> updateCustomer(
            @PathVariable Long id,
            @Valid @RequestBody CustomersRequestDTO dto) {
        return ResponseEntity.ok(customerService.updateCustomer(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.ok("Đã xóa khách hàng thành công");
    }

    @GetMapping("/search")
    public ResponseEntity<List<CustomersResponseDTO>> searchCustomers(@RequestParam String keyword) {
        return ResponseEntity.ok(customerService.searchByName(keyword));
    }
}