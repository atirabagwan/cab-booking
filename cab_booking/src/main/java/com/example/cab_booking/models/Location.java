package com.example.cab_booking.models;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Location {
    Integer x;
    Integer y;

    public Double distance(Location location2) {
        return sqrt(pow(this.x - location2.x, 2) + pow(this.y - location2.y, 2));
    }
}
