package org.example.chess;

import javafx.util.Pair;
import org.example.chess.enums.Enum;
import org.example.chess.model.Cell;
import org.example.chess.model.Player;
import org.example.chess.model.piece.Piece;

import java.util.ArrayList;
import java.util.List;

public class ChessGameController {

    ChessGame chessGame;
    Player currentTurn;
    Player player1;
    Player player2;

//    Map<Enum.Colour, List<Piece>> pieceMap;


    private ChessGameController(){
//        chessGame = new ChessGame();
//        initializeWithPieces();
    }
    private static ChessGameController instance;

    public static ChessGameController getInstance() {
        if(instance == null)
            instance = new ChessGameController();
        return instance;
    }

    public void setPlayers(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        setCurrentPlayer(player2);

    }

    public void initializeGame() {
//        initializeWithPieces();
        chessGame = new ChessGame();
        initializeWithPieces();
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentTurn = currentPlayer;
    }

    public boolean checkIfCurrentPlayerIsWinner() {
        return currentTurn.isWinner();
    }

    public void changeCurrentTurn() {
        currentTurn = currentTurn == player1 ? player2 :player1;
    }


    private void initializeWithPieces() {
        player1.setPieces(initializeColouredPieces(player1.getColour(), 1));
        player2.setPieces(initializeColouredPieces(player2.getColour(), 7));
    }

    private List<Piece> initializeColouredPieces(Enum.Colour colour, int position) {
        int pawnPositions = 1;
        if(position == 7) {
            pawnPositions = 6;
        }
        List<Piece> pieces = new ArrayList<>();
//        Piece piece =
        chessGame.board.getCell(position, 0).addPiece(PieceFactory.getInstance().getPiece(Enum.PieceType.ROOK, colour));
//        pieces.add(piece);
        for(int i=0;i<8;i++) {
            chessGame.board.getCell(pawnPositions, i).addPiece(PieceFactory.getInstance().getPiece(Enum.PieceType.PAWN, colour));
            pieces.add(chessGame.board.getCell(pawnPositions, i).getPiece());
            pieces.add(chessGame.board.getCell(position, i).getPiece());
        }
        return pieces;
    }

    public boolean move(Pair<Integer, Integer> source, Pair<Integer, Integer> destination) {
        Cell sourceCell = chessGame.board.getCell(source.getKey(), source.getValue());
        Cell destinationCell = chessGame.board.getCell(destination.getKey(), destination.getValue());
        return isSuperficiallyValidMove(sourceCell, destinationCell) &&
                sourceCell.getPiece().move(sourceCell, destinationCell);
    }

    private boolean isSuperficiallyValidMove(Cell sourceCell, Cell destinationCell) {
        return (sourceCell.hasPiece()) &&
                sourceCell.getPiece().getColour() == currentTurn.getColour() &&
                (!destinationCell.hasPiece() || destinationCell.getPiece().getColour() != sourceCell.getPiece().getColour());

    }
}
