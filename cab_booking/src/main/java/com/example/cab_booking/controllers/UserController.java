package com.example.cab_booking.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.cab_booking.models.Driver;
import com.example.cab_booking.models.Location;
import com.example.cab_booking.models.User;
import com.example.cab_booking.services.UserService;

@RestController
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/add/user", method = RequestMethod.POST)
    public ResponseEntity addUser(final String id, final String name, final String number,
            final Location location) {
        User user = new User(id, name, number, location);
        userService.addUser(user);
        return ResponseEntity.ok("success");
    }

    @RequestMapping(value = "/update/user", method = RequestMethod.PUT)
    public ResponseEntity updateUser(final String id,
            final String name,
            final String number,
            final Location location) {
        User user = new User(id, name, number, location);
        userService.updateUser(user);
        return ResponseEntity.ok("success");
    }

    @RequestMapping(value = "/update/user/location", method = RequestMethod.PUT)
    public ResponseEntity updateUserLocation(final String id, final Location location) {
        userService.updateUserLocation(id, location);
        return ResponseEntity.ok("success");
    }

}
