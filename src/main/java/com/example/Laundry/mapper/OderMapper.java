package com.example.Laundry.mapper;

import com.example.Laundry.dto.OderRequestDTO;
import com.example.Laundry.dto.OderResponseDTO;
import com.example.Laundry.entity.Oder;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface OderMapper {
    Oder toEntity(OderRequestDTO oderRequestDTO);

    OderResponseDTO toResponseDTO(Oder oder);
}
