package org.example.Board;

import org.example.Figures.Figure;
import org.example.Figures.King;

import java.util.Arrays;
import java.util.List;

public class Checkmate {
    int[] kingPosition;
    Board board;

    public Checkmate(int[] kingPosition, Board board) {
        this.kingPosition = kingPosition;
        this.board = board;
    }

    public boolean canKingMoveToAnyPosition() {
        int y = kingPosition[0];
        int x = kingPosition[1];
        int[][] posAroundKing = {
                {y - 1, x},
                {y - 1, x + 1},
                {y - 1, x - 1},
                {y, x + 1},
                {y, x - 1},
                {y + 1, x},
                {y + 1, x + 1},
                {y + 1, x - 1}
        };
        for (int[] yx : posAroundKing) {
            boolean outOfBound = yx[0] < 0 || yx[0] > 7 || yx[1] < 0 || yx[1] > 7;
            if (!outOfBound && board.getBoard()[yx[0]][yx[1]] == null) {
                return true;
            }
        }
        return false;
    }

    public boolean canFigureMoveBetweenAttackerAndKing(Object playerSymbol, int[] figureTargetingKing) {
        Object[][] b = board.getBoard().clone();
        int[] kingPos = board.getKingPosition(playerSymbol);
        Between between = new Between(figureTargetingKing, kingPos, board.getBoard());
        List<List<Integer>> betweenPositions = between.getListOfPositionsBetween();
        List<List<Integer>> symbolFigures = board.getFigureListFromSymbol(playerSymbol);
        for (List<Integer> betweenPosition : betweenPositions) {
            int u = betweenPosition.get(0);
            int v = betweenPosition.get(1);
            for (List<Integer> figurePosition : symbolFigures) {
                int y = figurePosition.get(0);
                int x = figurePosition.get(1);
                Between between1 = new Between(new int[]{y, x}, new int[]{u, v}, board.getBoard());
                if (b[y][x] instanceof Figure && !(b[y][x] instanceof King)
                    && ((Figure) b[y][x]).canMove(new int[]{y, x}, new int[]{u, v}, board)
                    && !between1.isFigureInBetween()) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean canFigureAttackEnemy(int[] enemyFigure, Object playerSymbol) {
        Object[][] b = board.getBoard();
        BoardBuilder builder = new BoardBuilder(board);
        System.out.println(builder.buildLowerCaseBoard());
        for (int y = 0; y <= 7; y++) {
            for (int x = 0; x <= 7; x++) {
                Between between = new Between(new int[]{y, x}, enemyFigure, board.getBoard());
                if (b[y][x] instanceof Figure
                    && ((Figure) b[y][x]).getSymbol().getClass() == playerSymbol.getClass()
                    && ((Figure) b[y][x]).canMove(new int[]{y, x}, enemyFigure, board) && !between.isFigureInBetween()) {
                    if (b[y][x] instanceof King) {
                        Figure enemyFigureClass = (Figure) b[enemyFigure[0]][enemyFigure[1]];
                        List<List<Integer>> listOfEnemyFigures = board.getFigureListFromSymbol(enemyFigureClass.getSymbol());
                        for (List<Integer> figure : listOfEnemyFigures) {
                            int u = figure.get(0);
                            int v = figure.get(1);
                            Between between1 = new Between(new int[]{u, v}, new int[]{enemyFigure[0], enemyFigure[1]}, board.getBoard());
                            if (b[u][v] instanceof Figure && !Arrays.asList(u, v).equals(Arrays.asList(enemyFigure[0], enemyFigure[1]))
                                && ((Figure) b[u][v]).canMove(new int[]{u, v}, new int[]{enemyFigure[0], enemyFigure[1]}, board)
                                && !between1.isFigureInBetween()) {
                                return false;
                            }
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public int[] getFigureTargetingKingPos(Object playerSymbol) {
//        int[] kingPos = board.getKingPosition(playerSymbol);
        Object[][] b = board.getBoard();
        for (int y = 0; y <= 7; y++) {
            for (int x = 0; x <= 7; x++) {
                Between between = new Between(new int[]{y, x}, kingPosition, board.getBoard());
                if (b[y][x] instanceof Figure
                    && ((Figure) b[y][x]).getSymbol().getClass() != playerSymbol.getClass()
                    && ((Figure) b[y][x]).canMove(new int[]{y, x}, kingPosition, board)
                    && !between.isFigureInBetween()) {
                    return new int[]{y, x};
                }
            }
        }
        return null;
    }
}
