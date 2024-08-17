package org.example.elevator;

import org.example.elevator.algorithms.ElevatorControlStrategy;
import org.example.elevator.algorithms.PendingRequest;
import org.example.elevator.model.Direction;
import org.example.elevator.model.ElevatorCar;

import java.util.List;

public class ElevatorController {

    private ElevatorCar elevatorCar;

    public ElevatorController(int id) {
        this.elevatorCar = new ElevatorCar(id);
    }

    public ElevatorCar getElevatorCar() {
        return elevatorCar;
    }

    public void acceptRequest(int floor, Direction dir){
        Building.elevatorControlStrategy.pendingRequestList.add(new PendingRequest(floor, dir));
        controlCar();
    }

    public void controlCar(){
        Building.elevatorControlStrategy.moveElevator(this);
    }
}
