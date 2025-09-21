package com.example.Laundry.repository;

import com.example.Laundry.entity.OderStatusHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderStatusHistoryRepository extends JpaRepository<OderStatusHistory, Long> {
}
