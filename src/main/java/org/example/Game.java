package org.example;

import org.example.Board.Board;
import org.example.Board.BoardPrinter;
import org.example.Player.Players;

public class Game {
    Board board = new Board();
    Players players = new Players();
    BoardPrinter printer = new BoardPrinter(board, players);

    public void playGame() {
        printer.printBoard();
        board.moveFigure();
    }
}
