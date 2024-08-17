package org.example.tictactoe.model;

public enum PieceType {

    X('X'),
    O('O');
    private final char val;

    PieceType(char val){
        this.val = val;
    }

    public char getVal() {
        return val;
    }
}
