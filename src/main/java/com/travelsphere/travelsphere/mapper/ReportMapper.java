package com.travelsphere.travelsphere.mapper;

import com.travelsphere.travelsphere.dto.ReportDto;
import com.travelsphere.travelsphere.model.Report;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ReportMapper {
    ReportDto toDto(Report report);
    Report toEntity(ReportDto reportDto);
}
