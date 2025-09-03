package com.example.Laundry.service.implement;

import com.example.Laundry.dto.OderDetailRequestDTO;
import com.example.Laundry.dto.OderDetailResponseDTO;
import com.example.Laundry.entity.OderDetail;
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
        List<OderDetailResponseDTO> oderDetailResponseDTOS = new ArrayList<>();
        List<OderDetail> oderDetails = oderDetailRepository.findAll();
        for (OderDetail o : oderDetails)
        {
            OderDetailResponseDTO dto = OderDetailResponseDTO.builder()
                    .id(o.getOderDetailId())
                    .price(o.getPrice())
                    .amount(o.getAmount())
                    .specialRequest(o.getSpecialRequest())
                    .build();
            oderDetailResponseDTOS.add(dto);
        }
        return oderDetailResponseDTOS;
    }

    @Override
    public List<OderDetailResponseDTO> getByOderId(Long oderId) {
       List<OderDetail> oderDetail = oderDetailRepository.findByOder_OderId(oderId);

       if(oderDetail.isEmpty()){
           throw new RuntimeException("oderId khong hop le:" + oderId);
       }

       return oderDetail.stream().map(oderDetail1 -> OderDetailResponseDTO.builder()
                       .id(oderDetail1.getOderDetailId())
                       .price(oderDetail1.getPrice())
                       .amount(oderDetail1.getAmount())
                       .specialRequest(oderDetail1.getSpecialRequest())
                       .build()
       )
               .toList();
    }

}
