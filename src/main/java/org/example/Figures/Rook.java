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
        return false;
    }
}
