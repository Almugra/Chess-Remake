package org.example.Figures;

import org.example.Board.Board;
import org.example.Board.Checkmate;
import org.example.Symbols.Lowercase;

import java.util.ArrayList;
import java.util.List;

public class Pawn implements Figure {

    public Object symbol;
    List<List<List<Integer>>> moveHistory = new ArrayList<>();

    public Pawn(Object symbol) {
        this.symbol = symbol;
    }

    public List<List<Integer>> getLastMove() {
        return moveHistory.get(moveHistory.size() - 1);
    }

    public void addMoveToMoveHistory(List<List<Integer>> moveHistory) {
        this.moveHistory.add(moveHistory);
    }

    public Object getSymbol() {
        return symbol;
    }

    @Override
    public boolean isLowercase() {
        return symbol instanceof Lowercase;
    }

    @Override
    public String toString() {
        return symbol.toString();
    }

    public boolean canMoveDirection(int[] start, int[] end) {
        if (symbol.getClass() == Lowercase.class) {
            return end[0] <= start[0];
        } else {
            return end[0] > start[0];
        }
    }

    public int getIncOrDec(int[] end) {
        if (symbol.getClass() == Lowercase.class) {
            return end[0] + 1;
        } else {
            return end[0] - 1;
        }
    }

    public boolean canMoveEnPassant(int[] start, int[] end, Board board) {
        Object[][] b = board.getBoard();
        int incOrDec = getIncOrDec(end);
        if (b[incOrDec][end[1]] instanceof Pawn
            && b[start[0]][start[1]] instanceof Pawn
            && ((Pawn) b[incOrDec][end[1]]).getSymbol() != symbol) {
            Integer lastMoveStartY = ((Pawn) b[incOrDec][end[1]]).getLastMove().get(0).get(0);
            Integer lastMoveEndY = ((Pawn) b[incOrDec][end[1]]).getLastMove().get(1).get(0);
            boolean lastMoveIsTwoInY = Math.abs(lastMoveStartY - lastMoveEndY) == 2;
            if (((Pawn) b[incOrDec][end[1]]).moveHistory.size() == 1
                && lastMoveIsTwoInY) {
                board.removeFigure(new int[]{incOrDec, end[1]});
                return true;
            }
        }
        System.out.println("En passant not possible!");
        return false;
    }

    @Override
    public boolean canMove(int[] startYX, int[] endYX, Board board) {
        Object[][] b = board.getBoard();
        boolean outOfBound = endYX[0] > 7 || endYX[0] < 0 || endYX[1] > 7 || endYX[1] < 0;
        if (outOfBound) {
            return false;
        }
        boolean moveTwoAfterMove = Math.abs(startYX[0] - endYX[0]) == 2
                                   && startYX[0] != 1
                                   && startYX[0] != 6;
        boolean allowedMoves = Math.abs(startYX[0] - endYX[0]) <= 2
                               && startYX[1] == endYX[1]
                               || Math.abs(startYX[0] - endYX[0]) == 1
                                  && Math.abs(startYX[1] - endYX[1]) == 1
                                  && (b[endYX[0]][endYX[1]] != null
                                      || canMoveEnPassant(startYX, endYX, board));
        return allowedMoves && !moveTwoAfterMove && canMoveDirection(startYX, endYX);
    }

    @Override
    public boolean isKingCheck(int[] from, int[] to, Board board) {
        board.setFigure(to, this);
        board.removeFigure(from);
        int[] relevantKingPosition = board.getKingPosition(symbol);
        Checkmate checkmate = new Checkmate(relevantKingPosition, board);
        return checkmate.getFigureTargetingKingPos(symbol) != null;
    }
}

