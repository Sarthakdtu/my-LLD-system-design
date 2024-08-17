package org.example.tictactoe.model.winning;

import org.example.tictactoe.model.Board;
import org.example.tictactoe.model.PieceType;

public interface WinningStrategy {
    boolean isOver(Board board, PieceType piece);
}
