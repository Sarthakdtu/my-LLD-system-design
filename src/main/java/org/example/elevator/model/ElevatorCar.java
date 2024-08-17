package org.example.elevator.model;

public class ElevatorCar {
    private int curentFloor;

    private final int id;
    ElevatorState state;
    Direction direction;
    Button button;

    Door door;

    public ElevatorCar(int id){
        button = new InternalButton();
        curentFloor = 0;
        direction = Direction.NONE;
        state = ElevatorState.IDLE;
        this.id = id;
        door = new Door();
    }

    public void pressButton(int floor){
        Direction dir = Direction.NONE;
        if(floor > curentFloor){
            dir = Direction.UP;
        }
        else if(floor < curentFloor){
            dir = Direction.DOWN;
        }
        button.pressButton(floor, dir, id);
    }

    public void move(Direction dir, int floor) {
        System.out.println("Elevator " + id + "moving " + dir);
        System.out.println("Elevator " + id + "stops at floor " + floor);
        curentFloor = floor;
        door.open(id);
        door.close(id);
    }

    public Direction getDirection() {
        return direction;
    }

    public ElevatorState getState() {
        return state;
    }

    public int getCurentFloor() {
        return curentFloor;
    }

    public int getId() {
        return id;
    }

}
