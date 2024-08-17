package org.example.elevator.dispatcher;

import org.example.elevator.Building;
import org.example.elevator.ElevatorController;
import org.example.elevator.model.Direction;

public class ExternalDispatcher {

    private static ExternalDispatcher instance;

    private ExternalDispatcher() { }


    public static ExternalDispatcher getInstance() {
        if(instance == null){
            instance = new ExternalDispatcher();
        }
        return instance;
    }

    void submitRequest(int floor, Direction direction) {
        int elId = Building.elevatorSelectionStrategy.selectElevator(floor, direction);
        for(ElevatorController elevatorController : Building.getInstance().getElevatorControllerList()) {
            if(elevatorController.getElevatorCar().getId() ==  elId) {
                elevatorController.acceptRequest(floor, direction);
            }
        }

    }
}
