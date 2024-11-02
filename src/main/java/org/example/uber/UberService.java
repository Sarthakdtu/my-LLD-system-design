package org.example.uber;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UberService {

    private Map<String, User> users;
    private Map<String, List<Trip>> trips;
    private Map<String, Trip> activeTrips;
    private Map<String, Driver> drivers;

    private UberService() {
        users = new HashMap<>();
        drivers = new HashMap<>();
        trips = new HashMap<>();
        activeTrips = new HashMap<>();
    }

    private static UberService instance;

    public static UberService getInstance() {
        if(instance == null)
            instance = new UberService();
        return instance;
    }

    void addUSer(User user) {
        users.put(user.username, user);
    }

    void addDriver(Driver driver) {drivers.put(driver.username, driver);}

    void requestRide(RideRequest request) {
        if(request.status == RideRequestStatus.REQUESTED) {
            List<Driver> nearByDrivers = getNearByDrivers(request.pickup, request.rideType);
            nearByDrivers.forEach(it ->it.notifyRideRequest(request));
        }
    }

    public synchronized Trip acceptRideRequest(Driver driver, RideRequest request) {
        if(request.status == RideRequestStatus.REQUESTED) {
            request.setDriver(driver);
            request.status = RideRequestStatus.ACCEPTED;
            driver.setStatus(DriverStatus.BUSY);
            driver.onAccept(request);
            request.user.notify("Ride has been accepted by " + driver.username);
            Trip trip = new Trip(request);
            activeTrips.put(request.user.username, trip);
            return trip;
        }
        return null;
    }

    private List<Driver> getNearByDrivers(Location location, RideType rideType) {
        return drivers.values()
                .stream()
                .filter( it -> it.status == DriverStatus.AVAILABLE
                        && it.location.getDistance(location) <= 5.0
                        && it.rideType == rideType
                )
                .collect(Collectors.toList());
    }

    public void startTrip(Trip trip) {
        if(trip.status == TripStatus.ACCEPTED) {
            trip.status = TripStatus.IN_PROGRESS;
            trip.driver.notify("Ride started");
            trip.user.notify("Ride started");
        }
    }

    public void cancelTrip(Trip trip) {
        if(trip.status == TripStatus.IN_PROGRESS || trip.status == TripStatus.ACCEPTED) {
            trip.status = TripStatus.CANCELLED;
            trip.driver.status = DriverStatus.AVAILABLE;
            trips.get(trip.user.username).add(trip);
            activeTrips.remove(trip.user.username);
        }
    }

    public void completeTrip(Trip trip) {
        if(trip.status == TripStatus.IN_PROGRESS) {
            trip.status = TripStatus.COMPLETED;
            trip.driver.status = DriverStatus.AVAILABLE;
            trips.get(trip.user.username).add(trip);
            activeTrips.remove(trip.user.username);
            trip.user.notify("Ride ended");
            trip.driver.notify("Ride ended");
            trip.setDuration(Instant.now());
        }
    }
}
