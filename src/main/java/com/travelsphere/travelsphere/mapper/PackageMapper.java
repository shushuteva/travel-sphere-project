package com.travelsphere.travelsphere.mapper;

import com.travelsphere.travelsphere.dto.PackageDto;
import com.travelsphere.travelsphere.model.Package;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PackageMapper {
    PackageDto toDto(Package packageEntity);
    Package toEntity(PackageDto packageDto);
}
