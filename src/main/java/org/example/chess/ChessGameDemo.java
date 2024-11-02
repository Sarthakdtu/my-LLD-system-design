package org.example.chess;

import javafx.util.Pair;
import org.example.chess.enums.Enum;
import org.example.chess.model.ComputerPlayer;
import org.example.chess.model.HumanPlayer;
import org.example.chess.model.Player;

public class ChessGameDemo {

    public static void main(String[] args) {
        ChessGameController chessGameController = ChessGameController.getInstance();
        Player player1 = new HumanPlayer(Enum.Colour.BLACK);
        Player player2 = new ComputerPlayer(Enum.Colour.WHITE);
        chessGameController.setPlayers(player1, player2);
        chessGameController.initializeGame();


        while(!chessGameController.checkIfCurrentPlayerIsWinner()) {
            chessGameController.changeCurrentTurn();
            int x = 0, y=1, z=1, w=1;
            do {
                x = 0; y=1; z=1;w=2;
            }
            while(!chessGameController.move(new Pair<>(x, y), new Pair<>(z, w)));
        }

    }
}
