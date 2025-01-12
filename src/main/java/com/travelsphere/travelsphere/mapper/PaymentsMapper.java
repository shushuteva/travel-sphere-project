package com.travelsphere.travelsphere.mapper;

import com.travelsphere.travelsphere.dto.PaymentsDto;
import com.travelsphere.travelsphere.model.Payments;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PaymentsMapper {
    PaymentsDto toDto(Payments payments);
    Payments toEntity(PaymentsDto paymentsDto);
}
