package com.example.Laundry.repository;

import com.example.Laundry.entity.OderResource;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OderResourceRepository extends JpaRepository<OderResource, Long> {
    Optional<List<OderResource>> findByOder_OderId(Long oderId);
}
