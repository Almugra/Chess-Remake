package org.example.Figures;

import org.example.Board.Board;
import org.example.Board.Checkmate;
import org.example.Symbols.Lowercase;

public class King implements Figure {

    public Object symbol;

    public King(Object symbol) {
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
        boolean movesMoreThenOne = Math.abs(startYX[0] - endYX[0]) > 1 || Math.abs(startYX[1] - endYX[1]) > 1;
        return !movesMoreThenOne;
    }

    @Override
    public boolean isKingCheck(int[] from, int[] to, Board board) {
        board.setFigure(to, this);
        board.removeFigure(from);
        Checkmate checkmate = new Checkmate(to, board);
        return checkmate.getFigureTargetingKingPos(symbol) != null;
    }

}
