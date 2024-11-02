package org.example.chess.model;

import org.example.chess.enums.Enum;

public interface MoveStrategy {
    boolean isValidMove(Cell sourceCell, Cell destinationCell, Enum.Colour colour);
}
