package com.example.Laundry.repository;

import com.example.Laundry.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomersRepository extends JpaRepository<Customer, Long> {
    boolean existsByEmail(String email);
    List<Customer> findByNameContainingIgnoreCase(String keyword);
}