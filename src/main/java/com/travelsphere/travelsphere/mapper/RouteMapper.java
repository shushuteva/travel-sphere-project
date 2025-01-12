package com.travelsphere.travelsphere.mapper;

import com.travelsphere.travelsphere.dto.RouteDto;
import com.travelsphere.travelsphere.model.Route;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RouteMapper {
    RouteDto toDto(Route route);
    Route toEntity(RouteDto routeDto);
}
