package org.example.chess.model.piece;

import org.example.chess.enums.Enum;
import org.example.chess.model.MoveStrategy;

public class PawnPiece extends Piece {

    public PawnPiece(MoveStrategy moveStrategy, Enum.Colour colour) {
        super(moveStrategy, Enum.PieceType.PAWN, colour);
    }
}
