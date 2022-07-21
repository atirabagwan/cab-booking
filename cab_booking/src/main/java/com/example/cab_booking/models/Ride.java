package com.example.cab_booking.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Ride {
    String id;
    Driver driver;
}
