package com.example.Laundry.repository;

import com.example.Laundry.OderStatus;
import com.example.Laundry.entity.Oder;
import com.example.Laundry.entity.OderDetail;
import com.example.Laundry.entity.OderStatusHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
public interface OderDetailRepository extends JpaRepository<OderDetail, Long> {
    Optional<List<OderDetail>> findByOder_OderId(Long oderId);
}


