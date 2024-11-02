package org.example.chess.model;

import javafx.util.Pair;
import org.example.chess.model.piece.Piece;

public class Cell {
    Piece piece;
    public boolean hasPiece(){
        return piece == null;
    }

    Pair<Integer, Integer> position;

    public Integer getX() {
        return position.getKey();
    }


    public Integer getY() {
        return position.getValue();
    }



    public void killPiece(){
        piece.markAsDead();
        removePiece();
    }

    public Piece getPiece() {
        return piece;
    }

    public void removePiece() {
        piece = null;
    }
    public void addPiece(Piece piece) {
        this.piece = piece;
    }

    public Cell(Integer x, Integer y) {
        position = new Pair<>(x, y);
        piece = null;
    }

}
