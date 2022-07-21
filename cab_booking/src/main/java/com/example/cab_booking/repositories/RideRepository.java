package com.example.cab_booking.repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.cab_booking.models.Location;
import com.example.cab_booking.models.Ride;
import com.example.cab_booking.models.User;

public class RideRepository {
    private static Integer MAX_DISTANCE = 5;
    Map<String, Ride> rides = new HashMap<>();

    public List<Ride> getAllRides(final Location userLocation) {
        List<Ride> availableRides = new ArrayList<>();
        for (Ride ride : rides.values()) {
            if (ride.getDriver().isAvailable()
                    && ride.getDriver().getLocation().distance(userLocation) <= MAX_DISTANCE) {
                availableRides.add(ride);
            }
        }
        return availableRides;
    }

    public Ride getRideByUserAndDriverId(User user, String driverId) {
        for (Ride ride : rides.values()) {
            if (ride.getDriver().getId() == driverId
                    && ride.getDriver().isAvailable()
                    && ride.getDriver().getLocation().distance(user.getLocation()) <= MAX_DISTANCE) {
                return ride;
            }
        }
        throw new IllegalArgumentException("Ride not available.");
    }

}
