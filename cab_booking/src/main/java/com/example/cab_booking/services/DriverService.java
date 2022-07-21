package com.example.cab_booking.services;

import java.util.NoSuchElementException;

import com.example.cab_booking.models.Driver;
import com.example.cab_booking.models.Location;
import com.example.cab_booking.repositories.DriverRepository;

public class DriverService {

    private DriverRepository driverRepository;

    public DriverService(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    public void addDriver(final Driver driver) {
        if (driverRepository.existByDriverId(driver.getId())) {
            throw new IllegalArgumentException("Driver already exists.");
        }

        driverRepository.save(driver);

    }

    public void updateDriverLocation(final String id, final Location location) {
        if (!driverRepository.existByDriverId(id)) {
            throw new NoSuchElementException("Driver not found.");
        }
        driverRepository.updateDriverLocation(id, location);
    }

    public void updateDriverStatus(final String id, final boolean status) {
        if (!driverRepository.existByDriverId(id)) {
            throw new NoSuchElementException("Driver not found.");
        }
        driverRepository.updateDriverStatus(id, status);
    }

    public void updateDriverEarnings(final String id, final Double earnings) {
        if (!driverRepository.existByDriverId(id)) {
            throw new NoSuchElementException("Driver not found.");
        }
        driverRepository.updateDriverEarnings(id, earnings);
    }

}
