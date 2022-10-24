package org.example;

import org.example.Board.Board;
import org.example.Board.BoardPrinter;
import org.example.Board.Checkmate;
import org.example.Player.Player;
import org.example.Player.Players;

public class Game {
    Board board = new Board();
    Players players = new Players();
    BoardPrinter printer = new BoardPrinter(board, players);
    Checkmate checkmate;

    public void playTurn() {
        Player currentPlayer = players.getCurrentPlayer();
        checkmate = new Checkmate(board.getKingPosition(currentPlayer.getSymbol()), board);
        int[] figureTargetingKing = checkmate.getFigureTargetingKingPos(currentPlayer.getSymbol());
        if (figureTargetingKing != null) {
            boolean figureCanAttackEnemyFigure = checkmate.canFigureAttackEnemy(figureTargetingKing, currentPlayer.getSymbol());
            boolean figureCanMoveBetweenAttackerAndKing = checkmate.canFigureMoveBetweenAttackerAndKing(currentPlayer.getSymbol(), figureTargetingKing);
            if (!figureCanMoveBetweenAttackerAndKing && !figureCanAttackEnemyFigure) {
                System.out.println("Checkmate!");
            }
        }
        printer.printBoard();
        board.moveFigure(currentPlayer.getSymbol());
        players.changeToNextPlayer();
    }

    public void playGame() {
        while (!board.isCheckmate) {
            playTurn();
        }
    }
}
