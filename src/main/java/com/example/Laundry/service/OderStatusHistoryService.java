package com.example.Laundry.service;

import com.example.Laundry.OderStatus;
import com.example.Laundry.entity.Oder;
import com.example.Laundry.entity.OderStatusHistory;

import java.util.List;


public interface OderStatusHistoryService {
    public Oder updateStatus(Long orderId, OderStatus newStatus);
    public List<OderStatusHistory> getTracking(Long oderId);
}
