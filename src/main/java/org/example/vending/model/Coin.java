package org.example.vending.model;

public enum Coin {
    FIVE(5),
    TEN(10),
    TWENTY(20)
    ;

    private final int amount;
    Coin(int amount){
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }
}
