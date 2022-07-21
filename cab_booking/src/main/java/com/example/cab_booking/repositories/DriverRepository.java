package com.example.cab_booking.repositories;

import java.util.HashMap;
import java.util.Map;

import com.example.cab_booking.models.Driver;
import com.example.cab_booking.models.Location;

public class DriverRepository {
  Map<String, Driver> drivers = new HashMap<>();

  public void save(final Driver driver) {
    drivers.put(driver.getId(), driver);
  }

  public boolean existByDriverId(String id) {
    return drivers.containsKey(id);
  }

  public void updateDriverLocation(String id, Location location) {
    Driver driver = drivers.get(id);
    driver.setLocation(location);
    drivers.put(id, driver);
  }

  public void updateDriverEarnings(String id, Double newEarning) {
    Driver driver = drivers.get(id);
    Double driverEarning = driver.getTotalEarning();
    driver.setTotalEarning(driverEarning + newEarning);
    drivers.put(id, driver);
  }

  public void updateDriverStatus(String id, boolean status) {
    Driver driver = drivers.get(id);
    driver.setAvailable(status);
    drivers.put(id, driver);
  }

  public Map<String, Double> getTotalEarnings() {
    Map<String, Double> earnings = new HashMap<>();

    for (Driver driver : drivers.values()) {
      earnings.put(driver.getId(), driver.getTotalEarning());
    }

    return earnings;
  }

}
