package org.example.vending.model;

import org.example.vending.state.State;
import org.example.vending.state.StateFactory;


public class VendingMachine {

    private State state;
    private Inventory inventory;
    private Integer paidValue;

    private int currentCode;

    public VendingMachine() {
        this.state = StateFactory.getInstance().getIdleState();
        paidValue = 0;
        currentCode = 0;
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }

    public void resetMachine() {
        paidValue = 0;
        currentCode = 0;
    }

    public void setCode(int num) {
        this.currentCode += this.currentCode *10 + num;
    }

    public int getCurrentCode() {
        return currentCode;
    }

    public boolean isValidCode() {
        return this.currentCode / 10 > 0 && this.currentCode % 10 > 0;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public void addCoins(Coin coin) {
        paidValue += coin.getAmount();
    }

    public Integer getPaidValue() {
        return paidValue;
    }


    public Integer getItemPrice(int code) {
        int row = code / 10;
        int col = code % 10;
        return inventory.getItemPrice(row, col);
    }

    public Item dispenseItem(int code) {
        int row = code / 10;
        int col = code % 10;
        return this.inventory.dispenseItem(row, col);
    }
}
