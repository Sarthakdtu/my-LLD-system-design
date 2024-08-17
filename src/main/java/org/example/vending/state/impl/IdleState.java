package org.example.vending.state.impl;

import org.example.vending.model.Coin;
import org.example.vending.model.Item;
import org.example.vending.model.VendingMachine;
import org.example.vending.state.State;
import org.example.vending.state.StateFactory;

public class IdleState implements State {

    public IdleState() {
        System.out.println("Vending machine is in idle state");
    }

    @Override
    public void insertCoinButton(VendingMachine machine) {
        machine.setState(StateFactory.getInstance().getMoneyState());
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

    }

    @Override
    public void updateInventory(VendingMachine machine, Item item) {

    }

    @Override
    public void dispenseProduct(VendingMachine machine) {

    }
}
