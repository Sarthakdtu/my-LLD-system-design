package org.example.vending.model;

public class Item {

    Integer price;
    ItemType itemType;

    Item(int price, ItemType itemType) {
        this.price = price;
        this.itemType = itemType;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public Integer getPrice() {
        return price;
    }
}
