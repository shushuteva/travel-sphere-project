package com.travelsphere.travelsphere.mapper;

import com.travelsphere.travelsphere.dto.TicketDto;
import com.travelsphere.travelsphere.model.Ticket;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TicketMapper {
    TicketDto toDto(Ticket ticket);
    Ticket toEntity(TicketDto ticketDto);
}
