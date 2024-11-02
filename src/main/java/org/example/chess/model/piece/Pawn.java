package org.example.chess.model.piece;

import org.example.chess.enums.Enum;
import org.example.chess.model.MoveStrategy;

public class Pawn extends Piece {
    public Pawn(MoveStrategy moveStrategy, Enum.Colour colour) {
        super(moveStrategy, Enum.PieceType.KNIGHT, colour);
    }
}
