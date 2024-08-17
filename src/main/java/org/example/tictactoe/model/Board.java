package org.example.tictactoe.model;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class Board {
    public int size;
    Piece[][] board;

    int emptyPositionsCount;

    Board(int size){
        this.size = size;
        board = new Piece[size][size];
        emptyPositionsCount = size*size;
    }

    public PieceType getPiecetAt(int x, int y){
        if(x >= size || x <0 || y <0 || y>=size ){
            System.out.println("Invalid coordinates");
            return null;
        }
        else if(board[x][y] ==  null) {
            return null;
        }
        return board[x][y].pieceType;
    }

    public boolean addPiece(int x, int y, Piece piece){
        if(x >= size || x <0 || y <0 || y>=size ){
            System.out.println("Invalid coordinates");
            return false;
        }
        else if(board[x][y] == null){
            board[x][y] = piece;
            emptyPositionsCount--;
            return true;
        }
        else {
            System.out.println("Coordinate is already occupied");
            return false;
        }
    }

    public List<Pair<Integer, Integer>> getFreePieces(){
        List<Pair<Integer, Integer>> freePieces = new ArrayList<>();
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                if (board[i][j] == null){
                    freePieces.add(new Pair<>(i, j));
                }
            }
        }
        return freePieces;
    }

    public boolean isFull(){
        return emptyPositionsCount == 0;
    }

    public void display(){
        for (int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                System.out.print(getPiecetAt(i, j) + " ");
            }
            System.out.println();
        }
    }
}
