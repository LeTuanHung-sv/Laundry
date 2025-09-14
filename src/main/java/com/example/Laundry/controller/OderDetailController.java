package com.example.Laundry.controller;

import com.example.Laundry.dto.OderDetailRequestDTO;
import com.example.Laundry.dto.OderDetailResponseDTO;
import com.example.Laundry.service.OderDetailService;
import com.example.Laundry.service.implement.OderDetailServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.constraints.*;
import java.util.List;

@RestController
@RequestMapping("/order-details")
@RequiredArgsConstructor
public class OderDetailController {
    private final OderDetailService oderDetailService;

    @PostMapping("/create")
    public ResponseEntity<OderDetailResponseDTO> createDetail(
           @Valid @RequestBody OderDetailRequestDTO dto){
        return ResponseEntity.ok(oderDetailService.createOderDetail(dto));
    }

    @GetMapping
    public ResponseEntity<List<OderDetailResponseDTO>> getAllOderDetails(){
        return ResponseEntity.ok(oderDetailService.getAllOderDetails());
    }

    @GetMapping("/search")
    public List<OderDetailResponseDTO> search(@RequestParam(required = false) Long oderId) {
        return oderDetailService.getByOderId(oderId);
    }
}
