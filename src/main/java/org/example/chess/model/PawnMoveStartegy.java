package org.example.chess.model;

import org.example.chess.enums.Enum;

import java.util.Objects;

public class PawnMoveStartegy implements MoveStrategy{

    public PawnMoveStartegy() {}
    @Override
    public boolean isValidMove(Cell sourceCell, Cell destinationCell, Enum.Colour colour) {
        return (sourceCell.getY() + 1 == destinationCell.getY() && Objects.equals(sourceCell.getX(), destinationCell.getX()));
    }

}
