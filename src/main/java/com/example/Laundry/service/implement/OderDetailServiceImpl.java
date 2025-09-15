package com.example.Laundry.service.implement;

import com.example.Laundry.dto.OderDetailRequestDTO;
import com.example.Laundry.dto.OderDetailResponseDTO;
import com.example.Laundry.entity.OderDetail;
import com.example.Laundry.mapper.OderDetailMapper;
import com.example.Laundry.repository.OderDetailRepository;
import com.example.Laundry.service.OderDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor

public class OderDetailServiceImpl implements OderDetailService {

    private final OderDetailRepository oderDetailRepository;
    private final OderDetailMapper oderDetailMapper;

    @Override
    @Transactional
    public OderDetailResponseDTO createOderDetail(OderDetailRequestDTO requestDTO){
        OderDetail oderDetail = OderDetail.builder()
                .price(requestDTO.getPrice())
                .amount(requestDTO.getAmount())
                .specialRequest(requestDTO.getSpecialRequest())
                //.service(requestDTO.getService())
                .service(new com.example.Laundry.entity.Service())
                .build();
        OderDetail oderDetail1 = oderDetailRepository.save(oderDetail);
        return OderDetailResponseDTO.builder()
                .id(oderDetail1.getOderDetailId())
                .price(oderDetail1.getPrice())
                .amount(oderDetail1.getAmount())
                .specialRequest(oderDetail1.getSpecialRequest())
                //.service(oderDetail1.getService())
                .build();


    }

    @Override
    @Transactional(readOnly = true)
    public List<OderDetailResponseDTO> getAllOderDetails(){
        return oderDetailRepository.findAll()
                .stream()
                .map(o -> OderDetailResponseDTO.builder()
                        .id(o.getOderDetailId())
                        .price(o.getPrice())
                        .amount(o.getAmount())
                        .specialRequest(o.getSpecialRequest())
                        .build())
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<OderDetailResponseDTO> findById(Long oderId) {
       List<OderDetail> oderDetails = oderDetailRepository.findByOder_OderId(oderId)
               .orElseThrow(() -> new RuntimeException("orderId not found: " + oderId));

       return oderDetails.stream()
               .map(oderDetailMapper::toDto)
               .toList();
    }

}
