package org.example.Figures;

import org.example.Symbols.Lowercase;

public class Pawn implements Figure {

    public Object symbol;

    public Pawn(Object symbol) {
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
    public boolean canMove(int[] startXY, int[] goalXY) {
        return false;
    }
}

