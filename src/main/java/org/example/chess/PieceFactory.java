package org.example.chess;

import org.example.chess.enums.Enum;
import org.example.chess.model.piece.Piece;
import org.example.chess.model.piece.KnightPiece;
import org.example.chess.model.piece.PawnPiece;

public class PieceFactory {

    static PieceFactory instance;

    private PieceFactory() {
    }

    public static PieceFactory getInstance() {
        if(instance == null)
            instance = new PieceFactory();
        return instance;
    }

    public Piece getPiece(Enum.PieceType type, Enum.Colour colour) {
        switch (type) {
            case KNIGHT: return new KnightPiece(MoveStrategyFactory.getInstance().getStrategy(type), colour);
            case PAWN: return new PawnPiece(MoveStrategyFactory.getInstance().getStrategy(type), colour);
            default: return null;
        }
    }
}
