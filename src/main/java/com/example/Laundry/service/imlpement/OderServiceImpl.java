package com.example.Laundry.service.imlpement;

import com.example.Laundry.dto.OderRequestDTO;
import com.example.Laundry.dto.OderResponseDTO;
import com.example.Laundry.entity.Customer;
import com.example.Laundry.entity.Delivery;
import com.example.Laundry.entity.Oder;
import com.example.Laundry.mapper.OderMapper;
import com.example.Laundry.repository.CustomerRepository;
import com.example.Laundry.repository.DeliveryRepository;
import com.example.Laundry.repository.OderRepository;
import com.example.Laundry.service.OderService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor

public class OderServiceImpl implements OderService {

    private final OderRepository oderRepository;
    private final OderMapper oderMapper;
    private final CustomerRepository customerRepository;
    private final DeliveryRepository deliveryRepository;


    @Override
    @Transactional
    public OderResponseDTO createOder(OderRequestDTO requestDTO) {
//        customerRepository.findById(requestDTO.getCustomerId())
//                .orElseThrow(() -> new RuntimeException("customerId not found"));
//
//        deliveryRepository.findById(requestDTO.getDeliveryId())
//                .orElseThrow(() -> new RuntimeException("deliveryId not found"));

        Oder oder = new Oder();
        oder.setOderDate(requestDTO.getOderDate());
        oder.setTotalAmount(requestDTO.getTotalAmount());
        oder.setNote(requestDTO.getNote());
//        oder.setCustomer(customer);
//        oder.setDelivery(delivery);

        Oder savedOder = oderRepository.save(oder);
        return oderMapper.toResponseDTO(savedOder);
    }

    @Override
    public List<OderResponseDTO> getAllOder() {
        return oderRepository.findAll()
                .stream()
                .map(oderMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public OderResponseDTO getOderById(Long id) {
        Oder oder = oderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found with id: " + id));
        return oderMapper.toResponseDTO(oder);
    }
}
