package com.example.Laundry.service;

import com.example.Laundry.dto.OderDetailRequestDTO;
import com.example.Laundry.dto.OderDetailResponseDTO;

import java.util.List;

public interface OderDetailService {
    OderDetailResponseDTO createOderDetail(OderDetailRequestDTO requestDTO);
    List<OderDetailResponseDTO> getAllOderDetails();
    List<OderDetailResponseDTO> findById(Long oderId);
}
