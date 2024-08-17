package org.example.vending.model;

public class ItemCell {
    Item item;
    int count;

    public ItemCell(Item item, int count) {
        this.item = item;
        this.count = count;
    }

    private void decCount() {
        this.count--;
    }

    public boolean available() {
        return this.count > 0;
    }

    public Item getItem() {
        return item;
    }

    public Integer getItemPrice() {
        return item.price;
    }

    public Item dispenseItem() {
        this.decCount();
        return item;
    }
}
