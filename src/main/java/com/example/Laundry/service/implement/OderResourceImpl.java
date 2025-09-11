package com.example.Laundry.service.implement;

import com.example.Laundry.dto.OderResourceRequestDTO;
import com.example.Laundry.dto.OderResourceResponseDTO;
import com.example.Laundry.entity.Oder;
import com.example.Laundry.entity.OderResource;
import com.example.Laundry.entity.Resource;
import com.example.Laundry.repository.OderRepository;
import com.example.Laundry.repository.OderResourceRepository;
import com.example.Laundry.repository.ResourceRepository;
import com.example.Laundry.service.OderResourceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OderResourceImpl implements OderResourceService {

    private final OderRepository oderRepository;
    private final ResourceRepository resourceRepository;
    private final OderResourceRepository oderResourceRepository;

    @Override
    public OderResourceResponseDTO allocateResource(Long orderId, OderResourceRequestDTO dto) {
        Oder oder = oderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("orderId not found"));
        Resource resource = resourceRepository.findById(dto.getResourceId())
                .orElseThrow(() -> new RuntimeException("resource not found"));

        if(dto.getAllocatedAmount() > resource.getTotalAmount()) {
            throw new RuntimeException("hong du tai nguyen");
        }
        OderResource oderResource = OderResource.builder()
                .oder(oder)
                .resource(resource)
                .allocatedAmount(dto.getAllocatedAmount())
                .build();
        oderResourceRepository.save(oderResource);
        return OderResourceResponseDTO.builder()
                .resourceName(resource.getName())
                .resourceType(resource.getType())
                .allocatedAmount(dto.getAllocatedAmount())
                .build();
    }

    @Override
    public List<OderResourceResponseDTO> getResourcesByOrder(Long orderId){
        List<OderResource> list = oderResourceRepository.findByOderId(orderId);

        return list.stream()
                .map(or -> OderResourceResponseDTO.builder()
                        .resourceName(or.getResource().getName())
                        .resourceType(or.getResource().getType())
                        .allocatedAmount(or.getAllocatedAmount())
                        .build())
                .toList();
    }
}
