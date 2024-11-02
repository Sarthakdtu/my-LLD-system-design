package org.example.chess;

import com.sun.javafx.collections.MappingChange;
import org.example.chess.enums.Enum;
import org.example.chess.model.MoveStrategy;
import org.example.chess.model.PawnMoveStartegy;

import java.util.HashMap;
import java.util.Map;

public class MoveStrategyFactory {

    private MoveStrategyFactory() {
    }

    private static MoveStrategyFactory instance;

    Map<Enum.PieceType, MoveStrategy> moveStrategyMap;

    public static MoveStrategyFactory getInstance() {
        if(instance == null) {
            instance = new MoveStrategyFactory();
            instance.moveStrategyMap = new HashMap<>();
        }
        return instance;
    }

    public MoveStrategy getStrategy(Enum.PieceType pieceType) {
        switch (pieceType) {
            case PAWN: return moveStrategyMap.computeIfAbsent(pieceType, x -> new PawnMoveStartegy());
            case KNIGHT: return moveStrategyMap.computeIfAbsent(pieceType, x -> new PawnMoveStartegy());
            default: return null;
        }
    }
}
