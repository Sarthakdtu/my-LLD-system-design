package org.example.tictactoe.model;

import javafx.util.Pair;
import org.example.tictactoe.model.winning.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

import static org.example.tictactoe.model.PieceType.X;

public class TicTacToe {

    private List<WinningStrategy> winningStrategies;
    private Board board;
    private List<Player> players;

    public TicTacToe(int size, List<WinningStrategyType> winningStrategyTypes, List<Player> players) {
        this.board = new Board(size);
        this.players = players;
        this.winningStrategies = new ArrayList<>();
        for(WinningStrategyType winningStrategyType : winningStrategyTypes){
            switch (winningStrategyType){
                case VERTICAL: {
                    winningStrategies.add(new VerticalWinningStrategy());
                    break;
                }
                case HORIZONTAL: {
                    winningStrategies.add(new HorizontalWinningStrategy());
                    break;
                }

                case LEFT_DIAGONAL: {
                    winningStrategies.add(new LeftDiagonalWinningStrategy());
                    break;
                }

                case RIGHT_DIAGONAL: {
                    winningStrategies.add(new RightDiagonalWinningStrategy());
                    break;
                }
            }
        }
    }

    public void start() {
        while (!board.isFull()){
            for(Player player : players){
                makeMoveRandom(player);
                if(isWinner(player.getPiece().pieceType)){
                    System.out.println("Player " + player.getPiece().pieceType + " " + player.getName() + " won!!");
//                    board.display();
                    return;
                }
                else if(board.isFull()){
                    System.out.println("GameOver");
//                    board.display();
                    return;
                }
            }
        }
    }

    private void makeMoveRandom(Player player){
        boolean legalMove = false;
        List<Pair<Integer, Integer>> freePieces = board.getFreePieces();
        Random random = new Random();
        while(!legalMove) {
            int randomIndex = Math.abs(random.nextInt(freePieces.size()));
            legalMove = board.addPiece(freePieces.get(randomIndex).getKey(), freePieces.get(randomIndex).getValue(), player.getPiece());
        }
    }
    private void makeMove(Player player){
       int x = 0,y = 0;
       boolean legalMove = false;
       while(!legalMove){
           legalMove = board.addPiece(x, y, player.getPiece());
       }
    }

    private boolean isWinner(PieceType pieceType) {
        for (WinningStrategy winningStrategy : winningStrategies) {
            if (winningStrategy.isOver(board, pieceType)) {
                return true;
            }
        }
        return false;
    }
}
