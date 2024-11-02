package org.example.chess.model;

import javafx.util.Pair;
import org.example.chess.enums.Enum;
import org.example.chess.model.piece.Piece;

import java.util.List;

public abstract class Player {

    Enum.PlayerType type;

    Enum.Colour colour;

    List<Piece> pieces;

    public Player(Enum.PlayerType type, Enum.Colour colour) {
        this.type = type;
        this.colour = colour;
//        this.chessBoard = chessBoard;
    }

    public void setPieces(List<Piece> pieces) {
        this.pieces = pieces;
    }

    public boolean isWinner() {
        for(Piece piece : pieces){
            if(piece.getStatus() != Enum.PieceStatus.DEAD)
                return false;
        }
        return true;
    }

    public Enum.Colour getColour() {
        return colour;
    }

    public void setColour(Enum.Colour colour) {
        this.colour = colour;
    }

}
