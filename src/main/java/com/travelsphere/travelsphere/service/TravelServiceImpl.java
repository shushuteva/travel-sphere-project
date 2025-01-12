package com.travelsphere.travelsphere.service;

import com.travelsphere.travelsphere.dto.TravelDto;
import com.travelsphere.travelsphere.exceptions.LoginException;
import com.travelsphere.travelsphere.exceptions.TravelException;
import com.travelsphere.travelsphere.mapper.TravelMapper;
import com.travelsphere.travelsphere.model.CurrentSession;
import com.travelsphere.travelsphere.model.Travel;
import com.travelsphere.travelsphere.repository.SessionRepo;
import com.travelsphere.travelsphere.repository.TravelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TravelServiceImpl implements TravelService {

    @Autowired
    private TravelRepo travelRepo;

    @Autowired
    private SessionRepo sessionRepo;

    @Autowired
    private TravelMapper travelMapper;

    @Override
    public TravelDto createTravel(TravelDto travelDto, String key) throws TravelException, LoginException {
        validateAdminSession(key);

        Travel travel = travelMapper.toEntity(travelDto);
        Travel savedTravel = travelRepo.save(travel);

        return travelMapper.toDto(savedTravel);
    }

    @Override
    public List<TravelDto> viewAllTravels(String key) throws TravelException, LoginException {
        validateAdminSession(key);

        List<Travel> travels = travelRepo.findAll();
        if (travels.isEmpty()) {
            throw new TravelException("No travels available");
        }

        return travels.stream().map(travelMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public TravelDto updateTravel(TravelDto travelDto, String key) throws TravelException, LoginException {
        validateAdminSession(key);

        Travel existingTravel = travelRepo.findById(travelDto.getTravelId()).orElseThrow(() ->
                new TravelException("Travel not found with ID: " + travelDto.getTravelId()));
                
        existingTravel.setTravelName(travelDto.getTravelName());
        existingTravel.setDescription(travelDto.getDescription());

        Travel updatedTravel = travelRepo.save(existingTravel);
        return travelMapper.toDto(updatedTravel);
    }

    @Override
    public TravelDto getTravel(Integer id, String key) throws TravelException, LoginException {
        validateAdminSession(key);

        Travel travel = travelRepo.findById(id).orElseThrow(() ->
                new TravelException("Travel not found with ID: " + id));

        return travelMapper.toDto(travel);
    }

    private void validateAdminSession(String key) throws LoginException {
        CurrentSession currentSession = sessionRepo.findByUuid(key).orElseThrow(() ->
                new LoginException("Invalid session key"));

        if (!"ADMIN".equals(currentSession.getUserType())) {
            throw new LoginException("You are not authorized");
        }
    }
}
