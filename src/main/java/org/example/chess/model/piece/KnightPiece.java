package org.example.chess.model.piece;

import org.example.chess.enums.Enum;
import org.example.chess.model.MoveStrategy;

public class KnightPiece extends Piece {

    public KnightPiece(MoveStrategy moveStrategy, Enum.Colour colour) {
        super(moveStrategy, Enum.PieceType.KNIGHT, colour);
    }
}
