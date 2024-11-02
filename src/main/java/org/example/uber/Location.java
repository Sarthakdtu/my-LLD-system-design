package org.example.uber;

public class Location {
    String city;
    String area;
    String street;
    int pin;

    double getDistance(Location location) {
        return Math.abs(2.0 * (pin - location.pin));
    }
}
