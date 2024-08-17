package org.example.elevator;

import org.example.elevator.algorithms.ElevatorControlStrategy;
import org.example.elevator.algorithms.ElevatorSelectionStrategy;
import org.example.elevator.model.Floor;

import java.util.ArrayList;
import java.util.List;

public class Building {
    private List<ElevatorController> elevatorControllerList= new ArrayList<>();
    public static ElevatorControlStrategy elevatorControlStrategy;
    public static ElevatorSelectionStrategy elevatorSelectionStrategy;
    public List<Floor> floors= new ArrayList<Floor>();

    public static Building instance= new Building();

    public static Building getInstance() {
        return instance;
    }

    private Building(){
    }

    public static ElevatorControlStrategy getElevatorControlStrategy() {
        return elevatorControlStrategy;
    }

    public static ElevatorSelectionStrategy getElevatorSelectionStrategy() {
        return elevatorSelectionStrategy;
    }

    public List<ElevatorController> getElevatorControllerList() {
        return elevatorControllerList;
    }

    public void addFloor(Floor floor){
        floors.add(floor);
    }
    public void addElevator(ElevatorController e) {
        elevatorControllerList.add(e);
    }
    public void removeElevator(ElevatorController e) {
        elevatorControllerList.remove(e);
    }
    public void setElevatorControlStrategy(ElevatorControlStrategy elevatorControlStrategy) {
        this.elevatorControlStrategy= elevatorControlStrategy;
    }
    public void setElevatorSelectionStrategy(ElevatorSelectionStrategy elevatorSelectionStrategy) {
        this.elevatorSelectionStrategy= elevatorSelectionStrategy;
    }
}
