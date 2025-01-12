package com.travelsphere.travelsphere.mapper;

import com.travelsphere.travelsphere.dto.TravelDto;
import com.travelsphere.travelsphere.model.Travel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TravelMapper {
    TravelDto toDto(Travel travel);
    Travel toEntity(TravelDto travelDto);
}
