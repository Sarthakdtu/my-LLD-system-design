package org.example.chess.model.piece;

import org.example.chess.enums.Enum;
import org.example.chess.model.Cell;
import org.example.chess.model.MoveStrategy;

public abstract class Piece {
    Enum.PieceType type;

    Enum.PieceStatus status;

    MoveStrategy moveStrategy;

    Enum.Colour colour;

    public Piece(MoveStrategy moveStrategy, Enum.PieceType pieceType, Enum.Colour colour) {
        this.status = Enum.PieceStatus.ALIVE;
        this.moveStrategy = moveStrategy;
        this.colour = colour;
    }

    public void setColour(Enum.Colour colour) {
        this.colour = colour;
    }

    public Enum.Colour getColour() {
        return colour;
    }

    public void setType(Enum.PieceType type) {
        this.type = type;
    }

    public Enum.PieceType getType() {
        return type;
    }

    private void setStatus(Enum.PieceStatus status) {
        this.status = status;
    }

    public void markAsDead() {
        this.status = Enum.PieceStatus.DEAD;
    }

    public Enum.PieceStatus getStatus() {
        return status;
    }

    public boolean move(Cell sourceCell, Cell destinationCell) {
        if(moveStrategy.isValidMove(sourceCell, destinationCell, sourceCell.getPiece().colour)){
            if(destinationCell.hasPiece()){
                destinationCell.killPiece();
            }
            sourceCell.removePiece();
            destinationCell.addPiece(this);
            return true;
        }
        return false;
    }


}
