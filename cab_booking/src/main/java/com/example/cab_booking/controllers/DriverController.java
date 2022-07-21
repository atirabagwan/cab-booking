package com.example.cab_booking.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.cab_booking.models.Driver;
import com.example.cab_booking.models.Location;
import com.example.cab_booking.services.DriverService;

@RestController
public class DriverController {

    private DriverService driverService;

    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }

    @RequestMapping(value = "/add/driver", method = RequestMethod.POST)
    public ResponseEntity addDriver(final String id, final String name, final String vehicle,
            final Location location, final boolean status) {
        Driver driver = new Driver(id, name, vehicle, location, status, 0.0);
        driverService.addDriver(driver);
        return ResponseEntity.ok("success");
    }

    @RequestMapping(value = "/update/driver/location", method = RequestMethod.PUT)
    public ResponseEntity updateDriverLocation(final String id, final Location location) {
        driverService.updateDriverLocation(id, location);
        return ResponseEntity.ok("success");
    }

    @RequestMapping(value = "/update/driver/status", method = RequestMethod.PUT)
    public ResponseEntity updateDriverStatus(final String id, final Boolean status) {
        driverService.updateDriverStatus(id, status);
        return ResponseEntity.ok("success");
    }

}
