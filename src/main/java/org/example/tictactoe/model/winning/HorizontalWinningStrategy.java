package org.example.tictactoe.model.winning;

import org.example.tictactoe.model.Board;
import org.example.tictactoe.model.Piece;
import org.example.tictactoe.model.PieceType;

public class HorizontalWinningStrategy implements WinningStrategy {

    @Override
    public boolean isOver(Board board, PieceType piece) {
        int size = board.size;
        for(int i=0;i<size;i++){
            boolean samePieceType = true;
            for(int j=0;j<size;j++){
                if(board.getPiecetAt(i, j) != piece){
                    samePieceType = false;
                    break;
                }
            }
            if(samePieceType){
                System.out.println("Won by Horizontal Strategy");
                return true;
            }
        }
        return false;
    }
}
