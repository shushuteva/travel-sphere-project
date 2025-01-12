package com.travelsphere.travelsphere.mapper;

import com.travelsphere.travelsphere.dto.AdminDto;
import com.travelsphere.travelsphere.model.Admin;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AdminMapper {
    AdminDto toDto(Admin admin);
    Admin toEntity(AdminDto adminDto);
}
