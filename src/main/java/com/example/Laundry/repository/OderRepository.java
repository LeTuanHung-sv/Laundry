package com.example.Laundry.repository;

import com.example.Laundry.entity.Oder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OderRepository extends JpaRepository<Oder, Long> {
}
