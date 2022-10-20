package org.example.Figures;

import org.example.Symbols.Lowercase;

public class King implements Figure{

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
    public boolean canMove(int[] startYX, int[] endYX) {
        boolean movesTwo = Math.abs(startYX[0] - endYX[0]) >= 2 || Math.abs(startYX[1] - endYX[1]) >= 2;
        if (movesTwo) {
            return false;
        }
        return true;
    }

}
