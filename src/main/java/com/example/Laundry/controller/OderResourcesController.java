package com.example.Laundry.controller;

import com.example.Laundry.dto.OderResourceRequestDTO;
import com.example.Laundry.dto.OderResourceResponseDTO;
import com.example.Laundry.service.OderResourceService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor

public class OderResourcesController {
    private final OderResourceService orderResourceService;


    @PostMapping("/{orderId}/resources")
    public ResponseEntity<OderResourceResponseDTO> allocateResource(
            @PathVariable Long orderId,
            @Valid @RequestBody OderResourceRequestDTO requestDTO) {
        return ResponseEntity.ok(orderResourceService.allocateResource(orderId, requestDTO));
    }


    @GetMapping("/{orderId}/resources")
    public ResponseEntity<List<OderResourceResponseDTO>> getResources(@PathVariable Long orderId) {
        return ResponseEntity.ok(orderResourceService.getResourcesByOrder(orderId));
    }
}
