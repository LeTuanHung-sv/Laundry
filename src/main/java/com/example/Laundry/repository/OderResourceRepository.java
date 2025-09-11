package com.example.Laundry.repository;

import com.example.Laundry.entity.OderResource;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OderResourceRepository extends JpaRepository<OderResource, Long> {
    List<OderResource> findByOderId(Long oderId);
}
