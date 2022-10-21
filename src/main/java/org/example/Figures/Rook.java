package org.example.Figures;

import org.example.Symbols.Lowercase;

public class Rook implements Figure {
    public Object symbol;

    public Rook(Object symbol) {
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
        return Math.abs(startYX[0] - endYX[0]) == 0 && Math.abs(startYX[1] - endYX[1]) != 0
               || Math.abs(startYX[1] - endYX[1]) == 0 && Math.abs(startYX[0] - endYX[0]) != 0;
    }
}
