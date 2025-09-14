package com.example.Laundry.service.implement;

import com.example.Laundry.OderStatus;
import com.example.Laundry.dto.OderHistoryRequestDTO;
import com.example.Laundry.dto.OderHistoryResponsesDTO;
import com.example.Laundry.entity.Oder;
import com.example.Laundry.entity.OderStatusHistory;
import com.example.Laundry.repository.OderRepository;
import com.example.Laundry.repository.OrderStatusHistoryRepository;
import com.example.Laundry.service.OderStatusHistoryService;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Builder

public class OderStatusHistoryImpl implements OderStatusHistoryService {
    private final OrderStatusHistoryRepository historyRepository;
    private final OderRepository oderRepository;

    @Override
    public OderHistoryResponsesDTO createOder(OderHistoryRequestDTO requestDTO){
        Oder oder = Oder.builder()
                .oderDate(requestDTO.getOderDate())
                .totalAmount(requestDTO.getTotalAmount())
                .note(requestDTO.getNote())
                .build();
        Oder oder1 = oderRepository.save(oder);
        return OderHistoryResponsesDTO.builder()
                .oderId(oder1.getOderId())
                .oderDate(oder1.getOderDate())
                .totalAmount(oder1.getTotalAmount())
                .note(oder1.getNote())
                .build();
    }

    @Override
    public Oder updateStatus(Long orderId, OderStatus newStatus){
        Oder oder = oderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("oder not found"));

        oder.setStatus(newStatus);

        OderStatusHistory oderStatusHistory = OderStatusHistory.builder()
                .oder(oder)
                .oderStatus(newStatus)
                .changedAt(LocalDateTime.now())
                .build();
        oder.getOderStatusHistories().add(oderStatusHistory);

        historyRepository.save(oderStatusHistory);
        return oderRepository.save(oder);

    }

    @Override
    public List<OderStatusHistory> getTracking(Long oderId){
        Oder oder = oderRepository.findById(oderId)
                .orElseThrow(() -> new RuntimeException("oder not found"));
        return oder.getOderStatusHistories();
    }
}
