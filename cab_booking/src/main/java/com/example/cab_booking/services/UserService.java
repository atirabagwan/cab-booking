package com.example.cab_booking.services;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.example.cab_booking.models.Location;
import com.example.cab_booking.models.User;
import com.example.cab_booking.repositories.UserRepository;

@Service
public class UserService {

  private UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public void addUser(final User user) {
    if (userRepository.existByUserId(user.getId())) {
      throw new IllegalArgumentException("User already exists.");
    }

    userRepository.save(user);

  }

  public void updateUser(final User user) {
    if (!userRepository.existByUserId(user.getId())) {
      throw new NoSuchElementException("User not found.");
    }
    userRepository.save(user);
  }

  public void updateUserLocation(final String id, final Location location) {
    if (!userRepository.existByUserId(id)) {
      throw new NoSuchElementException("User not found.");
    }
    userRepository.updateUserLocation(id, location);
  }

  public User getUser(String userId) {
    if (userRepository.existByUserId(userId)) {
      return userRepository.findById(userId);
    }
    throw new NoSuchElementException("Driver not found.");
  }

}
