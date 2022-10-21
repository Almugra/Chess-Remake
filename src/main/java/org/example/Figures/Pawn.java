package org.example.Figures;

import org.example.Board.Board;
import org.example.Symbols.Lowercase;

public class Pawn implements Figure {

    public Object symbol;
    Board board;

    public Pawn(Object symbol, Board board) {
        this.symbol = symbol;
        this.board = board;
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
    public boolean canMove(int[] startYX, int[] endYX) {
        Object[][] b = board.getBoard();
        boolean moveTwoAfterMove = Math.abs(startYX[0] - endYX[0]) == 2
                                   && startYX[0] != 1
                                   && startYX[0] != 6;
        boolean allowedMoves = Math.abs(startYX[0] - endYX[0]) <= 2
                               && startYX[1] == endYX[1]
                               || Math.abs(startYX[0] - endYX[0]) == 1
                                  && Math.abs(startYX[1] - endYX[1]) == 1
                                  && b[endYX[0]][endYX[1]] != null;
        return allowedMoves && !moveTwoAfterMove;
    }
}

