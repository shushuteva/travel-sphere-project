package com.travelsphere.travelsphere.mapper;

import com.travelsphere.travelsphere.dto.HotelDto;
import com.travelsphere.travelsphere.model.Hotel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface HotelMapper {
    HotelDto toDto(Hotel hotel);
    Hotel toEntity(HotelDto hotelDto);
}
