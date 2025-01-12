package com.travelsphere.travelsphere.controller;

import com.travelsphere.travelsphere.dto.*;
import com.travelsphere.travelsphere.exceptions.*;
import com.travelsphere.travelsphere.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/Admins")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private HotelService hotelService;

    @Autowired
    private TravelService travelService;

    @Autowired
    private BusService busService;

    @Autowired
    private RouteService routeService;

    @Autowired
    private PackageService packageService;

    @PostMapping("/Admins")
    public ResponseEntity<AdminDto> createAdmin(@Valid @RequestBody AdminDto adminDto) throws AdminException {
        AdminDto savedAdmin = adminService.createAdmin(adminDto);
        return new ResponseEntity<>(savedAdmin, HttpStatus.CREATED);
    }

    @PostMapping("/Hotels/{key}")
    public ResponseEntity<HotelDto> createHotel(@Valid @RequestBody HotelDto hotelDto, @PathVariable("key") String key) throws HotelException, LoginException {
        HotelDto savedHotel = hotelService.createHotel(hotelDto, key);
        return new ResponseEntity<>(savedHotel, HttpStatus.CREATED);
    }

    @PostMapping("/Travels/{key}")
    public ResponseEntity<TravelDto> createTravel(@Valid @RequestBody TravelDto travelDto, @PathVariable("key") String key) throws TravelException, LoginException {
        TravelDto savedTravel = travelService.createTravel(travelDto, key);
        return new ResponseEntity<>(savedTravel, HttpStatus.CREATED);
    }

    @GetMapping("/Travels/{key}")
    public ResponseEntity<List<TravelDto>> getAllTravels(@PathVariable("key") String key) throws TravelException, LoginException {
        List<TravelDto> travels = travelService.viewAllTravels(key);
        return new ResponseEntity<>(travels, HttpStatus.OK);
    }

    @GetMapping("/Travels/{id}/{key}")
    public ResponseEntity<TravelDto> getTravel(@PathVariable("id") Integer travelId, @PathVariable("key") String key) throws TravelException, LoginException {
        TravelDto travel = travelService.getTravel(travelId, key);
        return new ResponseEntity<>(travel, HttpStatus.OK);
    }

    @PutMapping("/Travels/{key}")
    public ResponseEntity<TravelDto> updateTravel(@Valid @RequestBody TravelDto travelDto, @PathVariable("key") String key) throws TravelException, LoginException {
        TravelDto updatedTravel = travelService.updateTravel(travelDto, key);
        return new ResponseEntity<>(updatedTravel, HttpStatus.OK);
    }
}
