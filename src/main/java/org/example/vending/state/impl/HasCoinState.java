package org.example.vending.state.impl;

import org.example.vending.model.Coin;
import org.example.vending.model.Item;
import org.example.vending.model.VendingMachine;
import org.example.vending.state.State;
import org.example.vending.state.StateFactory;

public class HasCoinState implements State {

    public HasCoinState() {
        System.out.println("Vending machine is in coin state");
    }

    @Override
    public void insertCoinButton(VendingMachine machine) {
    }

    @Override
    public void insertCoin(VendingMachine machine, Coin coin) {
        machine.addCoins(coin);
    }

    @Override
    public void chooseProductButton(VendingMachine machine) {
        machine.setState(StateFactory.getInstance().getSelectionState());
    }

    @Override
    public void chooseProduct(VendingMachine machine, int code) {

    }

    @Override
    public void cancelButon(VendingMachine machine) {
        if(machine.getPaidValue() > 0){
            this.refundFullMoney(machine);
        }
        machine.setState(StateFactory.getInstance().getIdleState());
    }

    @Override
    public void refundFullMoney(VendingMachine machine) {
        System.out.println("Refunding " + machine.getPaidValue());
        machine.resetMachine();
    }

    @Override
    public void productSelectionCompleteButton(VendingMachine machine) {

    }

    @Override
    public void getChange(int changeValue) {

    }

    @Override
    public void updateInventory(VendingMachine machine, Item item) {

    }

    @Override
    public void dispenseProduct(VendingMachine machine) {

    }
}
