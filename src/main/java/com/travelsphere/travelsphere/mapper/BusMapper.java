package com.travelsphere.travelsphere.mapper;

import com.travelsphere.travelsphere.dto.BusDto;
import com.travelsphere.travelsphere.model.Bus;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BusMapper {
    BusDto toDto(Bus bus);
    Bus toEntity(BusDto busDto);
}
