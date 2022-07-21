package com.example.cab_booking.driverClass;

import java.util.Map;

import com.example.cab_booking.models.Driver;
import com.example.cab_booking.models.Location;
import com.example.cab_booking.models.Ride;
import com.example.cab_booking.models.User;
import com.example.cab_booking.services.RideService;
import com.example.cab_booking.services.UserService;

public class DriverClass {

    private static UserService userService;
    private static RideService rideService;

    public DriverClass(UserService userService) {
        this.userService = userService;
        this.rideService = rideService;
    }

    public static void main(String[] args) {
        Location location1 = new Location(0, 0);
        Location location2 = new Location(10, 0);
        Location location3 = new Location(15, 6);

        Location location4 = new Location(10, 1);
        Location location5 = new Location(11, 10);
        Location location6 = new Location(5, 3);

        User user1 = new User("abhishek", "abhishek", "1234", location1);
        User user2 = new User("rahul", "rahul", "4567", location2);
        User user3 = new User("nandini", "nandini", "8912", location3);

        // add users
        userService.addUser(user1);
        userService.addUser(user2);
        userService.addUser(user3);

        Driver driver1 = new Driver("driver1", "driver1", "vehicle1", location4, true, 0.0);
        Driver driver2 = new Driver("driver2", "driver2", "vehicle2", location4, true, 0.0);
        Driver driver3 = new Driver("driver3", "driver3", "vehicle3", location4, true, 0.0);

        // User trying to get a ride
        rideService.getAllRides("abhishek", location1);
        rideService.getAllRides("rahul", location2);

        // choose ride
        Ride ride = rideService.getRide("rahul", "driver1");

        // calculate bill
        rideService.calculateBill(location2, location3, user2, driver1);

        // total earnings by drivers
        Map<String, Double> earnings = rideService.findTotalEarnings();

        System.out.println(earnings);

    }

}
