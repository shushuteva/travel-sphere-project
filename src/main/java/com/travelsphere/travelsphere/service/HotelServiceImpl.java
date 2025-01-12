package com.travelsphere.travelsphere.service;

import com.travelsphere.travelsphere.dto.HotelDto;
import com.travelsphere.travelsphere.exceptions.HotelException;
import com.travelsphere.travelsphere.exceptions.LoginException;
import com.travelsphere.travelsphere.mapper.HotelMapper;
import com.travelsphere.travelsphere.model.CurrentSession;
import com.travelsphere.travelsphere.model.Hotel;
import com.travelsphere.travelsphere.repository.HotelRepo;
import com.travelsphere.travelsphere.repository.SessionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelRepo hotelRepo;

    @Autowired
    private SessionRepo sessionRepo;

    @Autowired
    private HotelMapper hotelMapper;

    @Override
    public HotelDto createHotel(HotelDto hotelDto, String key) throws HotelException, LoginException {
        validateAdminSession(key);

        Hotel hotel = hotelMapper.toEntity(hotelDto);
        Hotel savedHotel = hotelRepo.save(hotel);

        return hotelMapper.toDto(savedHotel);
    }

    private void validateAdminSession(String key) throws LoginException {
        CurrentSession currentSession = sessionRepo.findByUuid(key).orElseThrow(() ->
                new LoginException("Invalid session key"));

        if (!"ADMIN".equals(currentSession.getUserType())) {
            throw new LoginException("You are not authorized");
        }
    }
}
