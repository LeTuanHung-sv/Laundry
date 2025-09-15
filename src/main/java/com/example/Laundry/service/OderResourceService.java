package com.example.Laundry.service;

import com.example.Laundry.dto.OderResourceRequestDTO;
import com.example.Laundry.dto.OderResourceResponseDTO;

import java.util.List;

public interface OderResourceService {
    OderResourceResponseDTO allocateResource(Long orderId, OderResourceRequestDTO dto);
    List<OderResourceResponseDTO> getResourcesByOrder(Long orderId);
}
