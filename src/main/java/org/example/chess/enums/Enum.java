package org.example.chess.enums;

public class Enum {
    public enum Colour{
        BLACK,
        WHITE;
    }

    public enum PieceType {
        KING,
        QUEEN,
        PAWN,
        ROOK,
        BISHOP,
        KNIGHT
    }

    public enum GameStatus {
        READY,
        IN_PROGRESS,
        DRAW,
        WINNER_PLAYER1,
        WINNER_PLAYER2
    }

    public enum PlayerType {
        COMPUTER,
        HUMAN
    }

    public enum PieceStatus {
        ALIVE,
        DEAD
    }
}
