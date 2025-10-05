package com.example.Laundry.repository;

import com.example.Laundry.entity.Oder;
import com.example.Laundry.service.OderStatusHistoryService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OderRepository extends JpaRepository<Oder, Long> {
}
