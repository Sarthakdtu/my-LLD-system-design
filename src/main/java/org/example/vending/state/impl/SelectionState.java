package org.example.vending.state.impl;

import org.example.vending.model.Coin;
import org.example.vending.model.Item;
import org.example.vending.model.VendingMachine;
import org.example.vending.state.State;
import org.example.vending.state.StateFactory;

public class SelectionState implements State {

    public SelectionState() {
        System.out.println("Vending machine is in selection state");
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
    public void chooseProduct(VendingMachine machine, int num) {
        machine.setCode(num);
    }

    @Override
    public void cancelButon(VendingMachine machine) {
        if(machine.getPaidValue() > 0){
            this.refundFullMoney(machine);
        }
        machine.resetMachine();
        machine.setState(StateFactory.getInstance().getIdleState());
    }

    @Override
    public void refundFullMoney(VendingMachine machine) {
        System.out.println("Refunding " + machine.getPaidValue());
        machine.resetMachine();
    }

    @Override
    public void productSelectionCompleteButton(VendingMachine machine) {
        if(machine.isValidCode()){
            this.refundFullMoney(machine);
            machine.setState(StateFactory.getInstance().getIdleState());
        }
        else {
            int code = machine.getCurrentCode();
            Integer price = machine.getItemPrice(code);
            if (price == -1 || price > machine.getPaidValue()) {
                if (price == -1)
                    System.out.println("Item not avaialble or out of stock");
                else
                    System.out.println("Insufficient funds");
                this.refundFullMoney(machine);
                machine.setState(StateFactory.getInstance().getIdleState());
            }
            else{
                machine.setState(StateFactory.getInstance().getDispenseState());
            }
        }
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
