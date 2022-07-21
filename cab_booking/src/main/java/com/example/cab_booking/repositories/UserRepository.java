package com.example.cab_booking.repositories;

import java.util.HashMap;
import java.util.Map;

import com.example.cab_booking.models.Location;
import com.example.cab_booking.models.User;

public class UserRepository {
  Map<String, User> users = new HashMap<>();

  public User findById(String userId) {
    return users.get(userId);
  }

  public void save(final User user) {
    users.put(user.getId(), user);
  }

  public boolean existByUserId(String id) {
    return users.containsKey(id);
  }

  public void updateUserLocation(String id, Location location) {
    User user = users.get(id);
    user.setLocation(location);
    users.put(id, user);
  }

}
