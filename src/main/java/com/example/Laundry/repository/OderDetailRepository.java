package com.example.Laundry.repository;

import com.example.Laundry.entity.Oder;
import com.example.Laundry.entity.OderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface OderDetailRepository extends JpaRepository<OderDetail, Long> {
    List<OderDetail> findByOder_OderId(Long oderId);
}
