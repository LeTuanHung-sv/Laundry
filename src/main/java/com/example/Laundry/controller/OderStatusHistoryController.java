package com.example.Laundry.controller;

import com.example.Laundry.OderStatus;
import com.example.Laundry.entity.Oder;
import com.example.Laundry.entity.OderStatusHistory;
import com.example.Laundry.service.OderStatusHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/oders")
@RequiredArgsConstructor

public class OderStatusHistoryController {
    public final OderStatusHistoryService oderStatusHistoryService;

    @PutMapping("/{id}/status")
    public ResponseEntity<Oder> updateStatus(@PathVariable Long id,
                                             @RequestBody Map<String,String > request){
        OderStatus newStatus = OderStatus.valueOf(request.get("status"));
        return ResponseEntity.ok(oderStatusHistoryService.updateStatus(id,newStatus));
    }

    @GetMapping("{id}/tracking")
    public ResponseEntity<List<OderStatusHistory>> getTracking(@PathVariable Long id){
        return ResponseEntity.ok(oderStatusHistoryService.getTracking(id));
    }

}
