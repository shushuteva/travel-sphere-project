package com.travelsphere.travelsphere.service;

import java.io.Console;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.travelsphere.travelsphere.repository.*;

import com.travelsphere.travelsphere.exceptions.*;

import com.travelsphere.travelsphere.model.*;

import com.travelsphere.travelsphere.model.Package;


@Service
public class PackageServiceImpl implements PackageService {

    @Autowired
    private BusRepo busRepo;

    @Autowired
    private RouteRepo routeRepo;

    @Autowired
    private PackageRepo packageRepo;

    @Autowired
    private HotelRepo hotelRepo;

    @Autowired
    private SessionRepo sessionRepo;


    @Override
    public Package createPackage(Package packagee,String key) throws PackageException, RouteException, LoginException {

        CurrentSession currentSession=	sessionRepo.findByUuid(key);
        if(currentSession==null) throw new LoginException("Please enter valid key ");

        if(!currentSession.getUserType().equals("ADMIN")) throw new LoginException("You are not authorized");




        Route existingRoute=routeRepo.findRoute(packagee.getSource(), packagee.getDestination(),packagee.getJourneyDate());

        if(existingRoute==null) throw new RouteException("For this Destination Route is not Available");



        List<Bus> buslist=existingRoute.getBus();

        if(buslist.size()==0) throw new PackageException("for this package bus is not available");



        Collections.sort(buslist,(s1,s2)->s1.getCapacity()<s2.getCapacity()?+1:-1);



        if(buslist.get(0).getCapacity()<packagee.getAvailableSeats()) throw new PackageException("For this packagee bus seats are not available");

        Hotel availablehotel = hotelRepo.findByHotelAddress(packagee.getDestination());




        if(availablehotel==null)throw new PackageException("For this packagee  hotel is not available");




        packagee.setHotel(availablehotel);

        packagee.setBus(buslist.get(0));

        buslist.get(0).setCapacity( buslist.get(0).getCapacity()-packagee.getAvailableSeats());

        packagee.setRoute(existingRoute);



        return  packageRepo.save(packagee);





    }


    @Override
    public Package searchPackage(Integer packageId) throws PackageException {
        // TODO Auto-generated method stub


        return packageRepo.findById(packageId).orElseThrow(()-> new PackageException("Package not found"));


    }


    @Override
    public List<Package> viewAllPackages() throws PackageException {
        // TODO Auto-generated method stub

        List<Package> packages=packageRepo.findAll();

        if(packages.size()==0) throw new PackageException("package not found");

        return packages;
    }



}
