package org.example.vending.state.impl;

import org.example.vending.model.Coin;
import org.example.vending.model.Item;
import org.example.vending.model.VendingMachine;
import org.example.vending.state.State;
import org.example.vending.state.StateFactory;

public class DispenseState implements State {

    public DispenseState() {
        System.out.println("Vending machine is in dispense state");
    }

    @Override
    public void insertCoinButton(VendingMachine machine) {
    }

    @Override
    public void insertCoin(VendingMachine machine, Coin coin) {

    }

    @Override
    public void chooseProductButton(VendingMachine machine) {

    }

    @Override
    public void chooseProduct(VendingMachine machine, int code) {
    }

    @Override
    public void cancelButon(VendingMachine machine) {

    }

    @Override
    public void refundFullMoney(VendingMachine machine) {

    }

    @Override
    public void productSelectionCompleteButton(VendingMachine machine) {

    }

    @Override
    public void getChange(int changeValue) {
        System.out.println("Dispensing change " + changeValue);
    }

    @Override
    public void updateInventory(VendingMachine machine, Item item) {

    }

    @Override
    public void dispenseProduct(VendingMachine machine) {
        Integer price = machine.getItemPrice(machine.getCurrentCode());
        Item item = machine.dispenseItem(machine.getCurrentCode());
        System.out.println("Here is the item " + item.getItemType());
        int diffAmount = price - machine.getPaidValue();
        if (diffAmount > 0) {
            this.getChange(diffAmount);
        }
        machine.resetMachine();
        machine.setState(StateFactory.getInstance().getIdleState());
    }
}
