package org.example.vending.state;

import org.example.vending.model.Coin;
import org.example.vending.model.Item;
import org.example.vending.model.VendingMachine;

public interface State {
    void insertCoinButton(VendingMachine machine);
    void insertCoin(VendingMachine machine, Coin coin);
    void chooseProductButton(VendingMachine machine);
    void chooseProduct(VendingMachine machine, int num);
    void cancelButon(VendingMachine machine);
    void refundFullMoney(VendingMachine machine);
    void productSelectionCompleteButton(VendingMachine machine);
    void getChange(int changeValue);
    void updateInventory(VendingMachine machine, Item item);

    void dispenseProduct(VendingMachine machine);

}
