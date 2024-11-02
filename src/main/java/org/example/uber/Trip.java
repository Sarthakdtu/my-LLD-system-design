package org.example.uber;

import java.time.Instant;
import java.time.LocalDateTime;

public class Trip {
    User user;
    Location pickUp;
    Location dropOff;
    Driver driver;
    Double fare;
    TripStatus status;

    Instant startTime;
    Instant endTime;


    public void setStatus(TripStatus status) {
        this.status = status;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public void setFare(Double fare) {
        this.fare = fare;
    }

    public Trip (RideRequest request) {
        user = request.user;
        driver = request.driver;
        status = TripStatus.ACCEPTED;
        fare = request.fare;
        pickUp = request.pickup;
        dropOff = request.drop;
    }

    public void setStartTime(Instant startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(Instant endTime) {
        this.endTime = endTime;
    }

    public void setDuration(Instant endTime) {
        setEndTime(endTime);
    }
}
