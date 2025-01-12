package com.travelsphere.travelsphere.mapper;

import com.travelsphere.travelsphere.dto.BookingDto;
import com.travelsphere.travelsphere.dto.PackageDto;
import com.travelsphere.travelsphere.model.Booking;
import com.travelsphere.travelsphere.model.Package;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {PackageMapper.class})
public interface BookingMapper {
    BookingDto toDto(Booking booking);
    Booking toEntity(BookingDto bookingDto);
}
