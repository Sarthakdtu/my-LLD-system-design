package org.example.elevator.algorithms;

import org.example.elevator.model.Direction;

public class PendingRequest {
    private int floor;
    private Direction direction;

    public PendingRequest(int floor, Direction direction) {
        this.floor = floor;
        this.direction = direction;
    }
}
