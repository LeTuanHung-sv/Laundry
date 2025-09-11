package com.example.Laundry.service;

import com.example.Laundry.dto.OderResourceRequestDTO;
import com.example.Laundry.dto.OderResourceResponseDTO;

import java.util.List;

public interface OderResourceService {
    public OderResourceResponseDTO allocateResource(Long orderId, OderResourceRequestDTO dto);

    public List<OderResourceResponseDTO> getResourcesByOrder(Long orderId);
}
