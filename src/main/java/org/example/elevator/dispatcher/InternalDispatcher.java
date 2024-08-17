package org.example.elevator.dispatcher;

import com.sun.javafx.sg.prism.NGCamera;
import org.example.elevator.Building;
import org.example.elevator.ElevatorController;
import org.example.elevator.model.Direction;

public class InternalDispatcher {

    private static InternalDispatcher internalDispatcher;

    private InternalDispatcher() {}

    public  void submitRequest(int floor, Direction dir, int elevatorId)
    {
        for(ElevatorController eController: Building.instance.getElevatorControllerList())
        {
            if(eController.getElevatorCar().getId()== elevatorId) {
                eController.acceptRequest(floor, dir);
            }
        }
    }
}
