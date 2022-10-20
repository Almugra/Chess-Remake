package org.example.Figures;

import org.example.Symbols.Lowercase;

public class Queen implements Figure{
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
    public boolean canMove(int[] startYX, int[] endYX) {
        boolean movesSquiggled = Math.abs(startYX[0] - endYX[0]) != Math.abs(startYX[1] - endYX[1]);
        return !movesSquiggled;
    }

}
