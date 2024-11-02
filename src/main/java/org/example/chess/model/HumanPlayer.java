package org.example.chess.model;

import javafx.util.Pair;
import org.example.chess.enums.Enum;

public class HumanPlayer extends Player{
    public HumanPlayer(Enum.Colour colour) {
        super(Enum.PlayerType.HUMAN, colour);
    }
}
