package org.example;

import org.example.Board.Board;
import org.example.Board.BoardPrinter;
import org.example.Board.EndgameActions;
import org.example.Player.Player;
import org.example.Player.Players;

public class Game {
    Board board = new Board();
    Players players = new Players();
    BoardPrinter printer = new BoardPrinter(board, players);
    EndgameActions gameActions;

    public void playGame() {
        while (true) {
            Player currentPlayer = players.getCurrentPlayer();
            gameActions = new EndgameActions(board.getKingPosition(currentPlayer.getSymbol()), board);
            int[] figureTargetingKing = gameActions.getFigureTargetingKingPos(currentPlayer.getSymbol());
            if (figureTargetingKing != null) {
                boolean figureCanAttackEnemyFigure = gameActions.canFigureAttackEnemy(figureTargetingKing, currentPlayer.getSymbol());
                boolean figureCanMoveBetweenAttackerAndKing = gameActions.canFigureMoveBetweenAttackerAndKing(currentPlayer.getSymbol(), figureTargetingKing);
                boolean canKingMoveToAnyPosition = gameActions.canKingMoveToAnyPosition();
                if (!figureCanMoveBetweenAttackerAndKing && !figureCanAttackEnemyFigure && !canKingMoveToAnyPosition) {
                    System.out.printf("%s is checkmate!\n", players.getCurrentPlayer().getName());
                    System.out.printf("%s won!", players.peekOpponent().getName());
                    break;
                }
            }
            printer.printBoard();
            board.moveFigure(currentPlayer.getSymbol());
            players.changeToNextPlayer();
        }
    }
}
