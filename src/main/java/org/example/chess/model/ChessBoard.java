package org.example.chess.model;

public class ChessBoard {
    Cell[][] cells;


    public ChessBoard () {
        cells = new Cell[8][8];
        for(int i=0;i<8;i++) {
            for(int j =0;j<8;j++)
                cells[i][j] = new Cell(i, j);
        }
    }

    public Cell getCell(int i, int j) {
        return cells[i][j];
    }

}
