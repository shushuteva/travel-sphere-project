package com.travelsphere.travelsphere.mapper;

import com.travelsphere.travelsphere.dto.CustomerDto;
import com.travelsphere.travelsphere.model.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerDto toDto(Customer customer);
    Customer toEntity(CustomerDto customerDto);
}

