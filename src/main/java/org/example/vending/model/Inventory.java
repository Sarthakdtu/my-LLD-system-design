package org.example.vending.model;

import java.util.List;

public class Inventory {
    private List<ItemShelf> itemShelfList;

    public Inventory(List<ItemShelf> itemShelfList) {
        this.itemShelfList = itemShelfList;
    }


    public List<ItemShelf> getItemShelfList() {
        return itemShelfList;
    }

    private ItemCell getItemCell(int row, int col) {
        if(itemShelfList.size() < row){
            return null;
        }
        else{
            ItemCell cell = itemShelfList.get(row).getItemCell(col);
            if(cell != null && cell.available()){
                return cell;
            }
        }
        return null;
    }

    public Item dispenseItem(int row, int col) {
        ItemCell itemCell = this.getItemCell(row, col);
        if(itemCell != null) {
            return itemCell.dispenseItem();
        }
        return null;
    }

    public Integer getItemPrice(int row, int col) {
        ItemCell itemCell = this.getItemCell(row, col);
        if(itemCell != null) {
            return itemCell.getItemPrice();
        }
        return -1;
    }
}
