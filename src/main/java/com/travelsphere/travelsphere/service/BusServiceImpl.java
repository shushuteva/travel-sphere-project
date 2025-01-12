package com.travelsphere.travelsphere.service;

import com.travelsphere.travelsphere.dto.BusDto;
import com.travelsphere.travelsphere.exceptions.BusException;
import com.travelsphere.travelsphere.exceptions.LoginException;
import com.travelsphere.travelsphere.exceptions.TravelException;
import com.travelsphere.travelsphere.mapper.BusMapper;
import com.travelsphere.travelsphere.model.Bus;
import com.travelsphere.travelsphere.model.CurrentSession;
import com.travelsphere.travelsphere.model.Travel;
import com.travelsphere.travelsphere.repository.BusRepo;
import com.travelsphere.travelsphere.repository.SessionRepo;
import com.travelsphere.travelsphere.repository.TravelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BusServiceImpl implements BusService {

    @Autowired
    private BusRepo busRepo;

    @Autowired
    private TravelRepo travelRepo;

    @Autowired
    private SessionRepo sessionRepo;

    @Autowired
    private BusMapper busMapper;

    @Override
    public BusDto createBus(BusDto busDto, Integer travelId, String key) throws BusException, TravelException, LoginException {
        CurrentSession currentSession = sessionRepo.findByUuid(key)
            .orElseThrow(() -> new LoginException("Invalid session key"));
        if (currentSession == null) throw new LoginException("Please enter a valid key");

        if (!currentSession.getUserType().equals("ADMIN")) throw new LoginException("You are not authorized");

        Optional<Travel> optionalTravel = travelRepo.findById(travelId);
        if (optionalTravel.isEmpty()) {
            throw new TravelException("Travel company does not exist with ID " + travelId);
        }

        Travel travel = optionalTravel.get();

        Bus bus = busMapper.toEntity(busDto);
        bus.setTravel(travel);
        bus.setTravelName(travel.getTravelName());
        travel.getBusList().add(bus);

        Bus savedBus = busRepo.save(bus);
        return busMapper.toDto(savedBus);
    }
}
