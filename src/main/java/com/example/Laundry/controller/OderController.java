package com.example.Laundry.controller;

import com.example.Laundry.dto.OderRequestDTO;
import com.example.Laundry.dto.OderResponseDTO;
import com.example.Laundry.service.OderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/Oder")
@RequiredArgsConstructor

public class OderController {
    private final OderService oderService;

    @PostMapping("/create")
    public ResponseEntity<OderResponseDTO> createOder(
            @Valid @RequestBody OderRequestDTO oderRequestDTO){
        return ResponseEntity.ok(oderService.createOder(oderRequestDTO));
    }


    @GetMapping("/getAll")
    public ResponseEntity<List<OderResponseDTO>> getAllOder(){
        return ResponseEntity.ok(oderService.getAllOder());
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<OderResponseDTO> getOderById(@PathVariable Long oderId){
        return ResponseEntity.ok(oderService.getOderById(oderId));
    }

}
