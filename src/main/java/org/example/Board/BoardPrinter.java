package org.example.Board;

import org.example.Player.Players;

import static org.example.Symbols.Lowercase.LOWERCASE;

public class BoardPrinter {

    BoardBuilder builder;
    Players players;

    public BoardPrinter(Board board, Players players) {
        this.builder = new BoardBuilder(board);
        this.players = players;
    }

    public void printBoard() {
        if (players.getCurrentPlayer().getSymbol().equals(LOWERCASE)) {
            System.out.println(builder.buildLowerCaseBoard());
        } else {
            System.out.println(builder.buildUpperCaseBoard());
        }
        System.out.printf("It's %s's turn!\n", players.getCurrentPlayer().getName());
    }
}
