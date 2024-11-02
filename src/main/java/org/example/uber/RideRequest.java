package org.example.uber;

import java.util.UUID;

public class RideRequest {
    User user;
    String id;
    Location pickup;
    Location drop;
    RideType rideType;
    Driver driver;
    RideRequestStatus status;

    Double fare;

    public RideRequest(Location pickup, Location drop, User user) {
        id = UUID.randomUUID().toString();
        this.pickup = pickup;
        this.drop = drop;
        this.user = user;
        status = RideRequestStatus.REQUESTED;
        setFare();
    }

    private void setFare() {
        this.fare = pickup.getDistance(drop)*8.0;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }
}
