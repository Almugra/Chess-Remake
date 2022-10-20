package org.example;

import org.example.Board.Board;
import org.example.Board.BoardBuilder;

public class Game {
    public void playGame() {
        BoardBuilder builder = new BoardBuilder(new Board());
        System.out.println(builder.buildLowerCaseBoard());
    }
}
