package org.example.tictactoe.model.winning;

import org.example.tictactoe.model.Board;
import org.example.tictactoe.model.Piece;
import org.example.tictactoe.model.PieceType;

public class RightDiagonalWinningStrategy implements WinningStrategy {

    @Override
    public boolean isOver(Board board, PieceType piece) {
        int size = board.size;
        for(int i=0;i<size;i++){
            if(board.getPiecetAt(i, size - 1 - i) != piece){
               return false;
            }
        }
        System.out.println("Won by RD Strategy");
        return true;
    }
}
