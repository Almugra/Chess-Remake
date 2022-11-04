package org.example.Figures;

import org.example.Board.Board;
import org.example.Board.EndgameActions;
import org.example.Symbols.Lowercase;

public class Knight implements Figure {

    public Object symbol;

    public Knight(Object symbol) {
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
        boolean yTwoXOne = Math.abs(startYX[1] - endYX[1]) == 2 && Math.abs(startYX[0] - endYX[0]) == 1;
        boolean yOneXTwo = Math.abs(startYX[1] - endYX[1]) == 1 && Math.abs(startYX[0] - endYX[0]) == 2;
        return yOneXTwo || yTwoXOne;
    }

    @Override
    public boolean isKingCheck(int[] from, int[] to, Board board) {
        board.setFigure(to, this);
        board.removeFigure(from);
        int[] relevantKingPosition = board.getKingPosition(symbol);
        EndgameActions gameActions = new EndgameActions(relevantKingPosition, board);
        return gameActions.getFigureTargetingKingPos(symbol) != null;
    }

}
