package com.travelsphere.travelsphere.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelsphere.travelsphere.exceptions.*;
import com.travelsphere.travelsphere.model.*;
import com.travelsphere.travelsphere.model.*;
import com.travelsphere.travelsphere.repository.*;
@Service
public class TravelServiceImpl implements TravelService {



    @Autowired
    private TravelRepo travelRepo;

    @Autowired
    private SessionRepo sessionRepo;

    @Override
    public Travel createTravel(Travel travel,String key) throws TravelException, LoginException {

        CurrentSession currentSession=	sessionRepo.findByUuid(key);
        if(currentSession==null) throw new LoginException("Please enter valid key ");

        if(!currentSession.getUserType().equals("ADMIN")) throw new LoginException("You are not authorized");



        Travel savetravel=travelRepo.save(travel);

        return savetravel;
    }

    @Override
    public List<Travel> ViewTravel(String key) throws TravelException, LoginException {

        CurrentSession currentSession=	sessionRepo.findByUuid(key);
        if(currentSession==null) throw new LoginException("Please enter valid key ");

        if(!currentSession.getUserType().equals("ADMIN")) throw new LoginException("You are not authorized");



        List<Travel> list=travelRepo.findAll();

        if(list.size()==0)
            throw new TravelException("No Travel Exist");
        else
            return list;


    }

    @Override
    public Travel updateTravel(Travel travel,String key) throws TravelException, LoginException {

        CurrentSession currentSession=	sessionRepo.findByUuid(key);
        if(currentSession==null) throw new LoginException("Please enter valid key ");

        if(!currentSession.getUserType().equals("ADMIN")) throw new LoginException("You are not authorized");



        Optional<Travel> opt=travelRepo.findById(travel.getTravelId());
        if(opt.isPresent())
        {
            travelRepo.save(travel);
            return travel;
        }else
            throw new TravelException("No travel Found");

    }

    @Override
    public Travel getTravel(Integer Id,String key) throws TravelException, LoginException {

        CurrentSession currentSession=	sessionRepo.findByUuid(key);
        if(currentSession==null) throw new LoginException("Please enter valid key ");

        if(!currentSession.getUserType().equals("ADMIN")) throw new LoginException("You are not authorized");



        Optional<Travel> opt=travelRepo.findById(Id);
        if(opt.isPresent()) {
            Travel ExistingTravel=opt.get();
            return ExistingTravel;
        }
        else
            throw new TravelException("No Travel Found");

    }



}
