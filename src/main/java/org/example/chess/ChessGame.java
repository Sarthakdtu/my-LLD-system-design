package org.example.chess;

import org.example.chess.enums.Enum;
import org.example.chess.model.ChessBoard;
import org.example.chess.model.Player;

public class ChessGame {
    ChessBoard board;

//    Player currentTurn;

    Enum.GameStatus status;

    public ChessGame() {
        board = new ChessBoard();
        status = Enum.GameStatus.READY;
//        currentTurn = player1;
    }


}
