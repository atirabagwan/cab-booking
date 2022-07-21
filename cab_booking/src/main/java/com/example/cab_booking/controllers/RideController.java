package com.example.cab_booking.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.cab_booking.models.Driver;
import com.example.cab_booking.models.Location;
import com.example.cab_booking.models.Ride;
import com.example.cab_booking.models.User;
import com.example.cab_booking.services.RideService;

@RestController
public class RideController {

    private RideService rideService;

    public RideController(RideService rideService) {
        this.rideService = rideService;
    }

    @RequestMapping(value = "/get/rides", method = RequestMethod.GET)
    public ResponseEntity getAllRides(final String id, final Location source) {
        List<Ride> rides = rideService.getAllRides(id, source);
        return ResponseEntity.ok(rides);
    }

    @RequestMapping(value = "/get/ride", method = RequestMethod.GET)
    public ResponseEntity getRide(final String userId, final String driverId) {
        Ride ride = rideService.getRide(userId, driverId);
        return ResponseEntity.ok(ride);
    }

    @RequestMapping(value = "/get/bill", method = RequestMethod.GET)
    public ResponseEntity getBill(final Location source, final Location destination, User user,
            Driver driver) {
        Double bill = rideService.calculateBill(source, destination, user, driver);
        return ResponseEntity.ok(bill);
    }

    @RequestMapping(value = "/get/bill", method = RequestMethod.GET)
    public ResponseEntity getTotalEarnings() {
        Map<String, Double> earnings = rideService.findTotalEarnings();
        return ResponseEntity.ok(earnings);
    }

}
