package com.example.Laundry.mapper;

import com.example.Laundry.dto.OderDetailResponseDTO;
import com.example.Laundry.entity.OderDetail;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")

public interface OderDetailMapper {

    OderDetailResponseDTO toDto(OderDetail entity);

    List<OderDetailResponseDTO> toDtoList(List<OderDetail> entities);
}
