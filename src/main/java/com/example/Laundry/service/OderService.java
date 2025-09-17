package com.example.Laundry.service;

import com.example.Laundry.dto.OderRequestDTO;
import com.example.Laundry.dto.OderResponseDTO;

import java.util.List;

public interface OderService {
    OderResponseDTO createOder(OderRequestDTO requestDTO);
    List<OderResponseDTO> getAllOder();
    OderResponseDTO getOderById(Long id);
}
