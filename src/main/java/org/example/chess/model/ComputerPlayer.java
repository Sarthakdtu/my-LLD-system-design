package org.example.chess.model;

import javafx.util.Pair;
import org.example.chess.enums.Enum;

public class ComputerPlayer extends Player{


    public ComputerPlayer(Enum.Colour colour) {
        super(Enum.PlayerType.COMPUTER, colour);
    }
}
