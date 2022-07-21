package com.example.cab_booking.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Driver {
    String id;
    String name;
    String vehicle;
    Location location;
    boolean available;
    Double totalEarning;
}
