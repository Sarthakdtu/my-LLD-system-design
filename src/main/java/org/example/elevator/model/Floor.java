package org.example.elevator.model;

public class Floor {

    private int num;
    private int id;
    private Button button;

    public Floor(int num) {
        this.num = num;
        button= new ExternalButton();
    }

    public void pressButton(Direction dir) {
        button.pressButton(id, dir);

    }
}
