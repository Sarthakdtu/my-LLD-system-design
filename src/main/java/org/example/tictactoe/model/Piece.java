package org.example.tictactoe.model;

public class Piece {
    PieceType pieceType;

    Piece(PieceType pieceType){
        this.pieceType = pieceType;
    }

    public PieceType getPieceType() {
        return pieceType;
    }
}
