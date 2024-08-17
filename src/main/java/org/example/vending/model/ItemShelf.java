package org.example.vending.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ItemShelf {
    private Map<Integer, ItemCell> itemCellsMap;
    private int row;

    public ItemShelf(int row) {
        this.row = row;
        itemCellsMap = new HashMap<>();
    }

    public void setItemCells(List<ItemCell> itemCells) {
        Integer colNum = 1;
        for(ItemCell itemCell : itemCells) {
            itemCellsMap.put(colNum, itemCell);
            colNum++;
        }
    }

    public void setItemCellsForColumn(Integer colNum, ItemCell itemCells) {
        itemCellsMap.put(colNum, itemCells);
    }

    public int getRow() {
        return row;
    }

    public ItemCell getItemCell(int col) {
        return itemCellsMap.getOrDefault(col, null);
    }
}
