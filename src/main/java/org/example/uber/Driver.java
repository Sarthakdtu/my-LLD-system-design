package org.example.uber;

import java.util.List;
import java.util.Queue;

public class Driver {

    String username;

    RideType rideType;
    Location location;
    DriverStatus status;
    List<RideRequest> rideRequests;

    public void notifyRideRequest(RideRequest request) {
        String message = "New ride request " + request.toString();
        rideRequests.add(request);
        System.out.println(message);
    }

    public void setStatus(DriverStatus status) {
        this.status = status;
    }

    public void onAccept(RideRequest request) {
        rideRequests.remove(request);
    }

    public void notify(String message) {
        System.out.println(message);
    }

}
