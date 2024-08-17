package org.example.tictactoe;

import org.example.tictactoe.model.*;
import org.example.tictactoe.model.winning.WinningStrategyType;

import java.util.ArrayList;
import java.util.List;

public class TicTacToeGame {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        List<WinningStrategyType> winningStrategyTypes = new ArrayList<>();
        winningStrategyTypes.add(WinningStrategyType.HORIZONTAL);
        winningStrategyTypes.add(WinningStrategyType.LEFT_DIAGONAL);
        Piece pieceX = new PieceX(PieceType.X);
        Piece pieceO = new PieceO(PieceType.O);
        List<Player> players = new ArrayList<>();
        players.add(new Player("Sarthak", pieceX));
        players.add(new Player("Sanyam", pieceO));
        int numIterations = 1000;
        for(int i=0;i<numIterations;i++){
            TicTacToe ticTacToe = new TicTacToe(99, winningStrategyTypes, players);
            ticTacToe.start();
        }
    }
}