package com.example.cab_booking.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.cab_booking.models.Driver;
import com.example.cab_booking.models.Location;
import com.example.cab_booking.models.Ride;
import com.example.cab_booking.models.User;
import com.example.cab_booking.repositories.DriverRepository;
import com.example.cab_booking.repositories.RideRepository;
import com.example.cab_booking.repositories.UserRepository;

@Service
public class RideService {
    private static Double PRICE = 10.0;
    private RideRepository rideRepository;
    private UserRepository userRepository;
    private DriverRepository driverRepository;
    private DriverService driverService;
    private UserService userService;

    public RideService(RideRepository rideRepository,
            UserRepository user,
            DriverRepository driverRepository,
            DriverService driverService,
            UserService userService) {
        this.rideRepository = rideRepository;
        this.userRepository = userRepository;
        this.driverRepository = driverRepository;
        this.driverService = driverService;
        this.userService = userService;
    }

    public List<Ride> getAllRides(String userId, Location source) {
        return rideRepository.getAllRides(source);
    }

    public Ride getRide(String userId, String driverId) {
        User user = userRepository.findById(userId);
        driverService.updateDriverStatus(driverId, false);
        return rideRepository.getRideByUserAndDriverId(user, driverId);
    }

    public Double calculateBill(Location source, Location destination, User user, Driver driver) {
        Double bill = source.distance(destination) * PRICE;
        driverService.updateDriverEarnings(driver.getId(), bill);
        userService.updateUserLocation(user.getId(), destination);
        driverService.updateDriverLocation(driver.getId(), destination);
        return bill;
    }

    public Map<String, Double> findTotalEarnings() {
        Map<String, Double> earnings = driverRepository.getTotalEarnings();
        return earnings;
    }

}
