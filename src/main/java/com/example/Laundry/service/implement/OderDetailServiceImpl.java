package com.example.Laundry.service.implement;

import com.example.Laundry.dto.OderDetailRequestDTO;
import com.example.Laundry.dto.OderDetailResponseDTO;
import com.example.Laundry.entity.OderDetail;
import com.example.Laundry.mapper.OderDetailMapper;
import com.example.Laundry.repository.OderDetailRepository;
import com.example.Laundry.service.OderDetailService;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Builder
@RequiredArgsConstructor

public class OderDetailServiceImpl implements OderDetailService {

    private final OderDetailRepository oderDetailRepository;
    private final OderDetailMapper oderDetailMapper;

    @Override
    public OderDetailResponseDTO createOderDetail(OderDetailRequestDTO requestDTO){
        OderDetail oderDetail = OderDetail.builder()
                .price(requestDTO.getPrice())
                .amount(requestDTO.getAmount())
                .specialRequest(requestDTO.getSpecialRequest())
                .build();
        OderDetail oderDetail1 = oderDetailRepository.save(oderDetail);
        return OderDetailResponseDTO.builder()
                .id(oderDetail.getOderDetailId())
                .price(oderDetail.getPrice())
                .amount(oderDetail.getAmount())
                .specialRequest(oderDetail.getSpecialRequest())
                .build();


    }

    @Override
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
    public List<OderDetailResponseDTO> getByOderId(Long oderId) {
       List<OderDetail> oderDetails = oderDetailRepository.findByOder_OderId(oderId);

       if(oderDetails.isEmpty()){
           throw new RuntimeException("oderId khong hop le:" + oderId);
       }

       return oderDetailMapper.toDtoList(oderDetails);
    }

}
