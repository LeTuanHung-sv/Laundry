package com.example.Laundry.service;

import com.example.Laundry.OderStatus;
import com.example.Laundry.dto.OderHistoryRequestDTO;
import com.example.Laundry.dto.OderHistoryResponsesDTO;
import com.example.Laundry.entity.Oder;
import com.example.Laundry.entity.OderStatusHistory;

import java.util.List;


public interface OderStatusHistoryService {
    OderHistoryResponsesDTO createOder(OderHistoryRequestDTO requestDTO);
    Oder updateStatus(Long orderId, OderStatus newStatus);
    List<OderStatusHistory> getTracking(Long oderId);
}
