package com.example.Laundry.mapper;

import com.example.Laundry.dto.OderResourceResponseDTO;
import com.example.Laundry.entity.OderResource;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import java.util.List;

@Mapper(componentModel = "spring")

public interface OderResourceMapper {
    OderResourceResponseDTO toResponseDTO(OderResource oderResource);

    List<OderResourceResponseDTO> toResponseDTOList(List<OderResource> oderResources);

}
