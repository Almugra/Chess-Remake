package org.example.Figures;

import org.example.Symbols.Lowercase;

public class Bishop implements Figure {

    public Object symbol;

    public Bishop(Object symbol) {
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
    public boolean canMove(int[] startYX, int[] endYX) {
        boolean movesStraight = startYX[1] == endYX[1] || startYX[0] == endYX[0];
        boolean movesSquiggled = Math.abs(startYX[0] - endYX[0]) != Math.abs(startYX[1] - endYX[1]);
        if (movesStraight || movesSquiggled) {
            return false;
        }
        return true;
    }

}
