package org.example.elevator.algorithms;

import org.example.elevator.model.Direction;

public interface ElevatorSelectionStrategy {
    int selectElevator(int floor, Direction direction);
}
