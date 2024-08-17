package org.example.elevator.algorithms;

import org.example.elevator.ElevatorController;

import java.util.LinkedList;
import java.util.Queue;

public interface ElevatorControlStrategy {
    Queue<PendingRequest> pendingRequestList = new LinkedList<>();
    void moveElevator(ElevatorController elevatorController);


}
