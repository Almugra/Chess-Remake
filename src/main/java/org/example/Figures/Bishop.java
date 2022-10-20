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
    public boolean canMove(int[] startXY, int[] endXY) {
        boolean movesStraight = startXY[1] == endXY[1] || startXY[0] == endXY[0];
        boolean movesSquiggled = Math.abs(startXY[0] - endXY[0]) != Math.abs(startXY[1] - endXY[1]);
        if (movesStraight || movesSquiggled) {
            return false;
        }
        return true;
    }

}
