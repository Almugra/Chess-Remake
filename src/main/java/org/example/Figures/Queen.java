package org.example.Figures;

import org.example.Board.Board;
import org.example.Board.Checkmate;
import org.example.Symbols.Lowercase;

public class Queen implements Figure {
    public Object symbol;

    public Queen(Object symbol) {
        this.symbol = symbol;
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

    @Override
    public boolean canMove(int[] startYX, int[] endYX, Board board) {
        boolean movesDiagonal = Math.abs(startYX[0] - endYX[0]) == Math.abs(startYX[1] - endYX[1]);
        boolean movesStraight = Math.abs(startYX[0] - endYX[0]) == 0 && Math.abs(startYX[1] - endYX[1]) != 0
                                || Math.abs(startYX[1] - endYX[1]) == 0 && Math.abs(startYX[0] - endYX[0]) != 0;
        return movesDiagonal || movesStraight;
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


