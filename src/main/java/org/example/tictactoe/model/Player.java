package org.example.tictactoe.model;

public class Player {
    private Piece piece;
    private String name;

    public Player(String name, Piece piece) {
        this.name = name;
        this.piece = piece;
    }

    public String getName() {
        return name;
    }

    public Piece getPiece() {
        return piece;
    }
}
