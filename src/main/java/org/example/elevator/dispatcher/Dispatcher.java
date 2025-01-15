package org.example.elevator.dispatcher;

import org.example.elevator.model.Direction;

public interface Dispatcher {
    void submitRequest(int floor, Direction direction, int elevatorId);
    void submitRequest(int floor, Direction direction);
}
