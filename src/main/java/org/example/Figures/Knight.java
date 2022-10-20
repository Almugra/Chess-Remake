package org.example.Figures;

import org.example.Symbols.Lowercase;

public class Knight implements Figure{

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
    public boolean canMove(int[] startYX, int[] endYX) {
        boolean movesStraight = startYX[1] == endYX[1] || startYX[0] == endYX[0];
        boolean yTwoXOne = Math.abs(startYX[1] - endYX[1]) == 2 && Math.abs(startYX[0] - endYX[0]) == 1;
        boolean yOneXTwo = Math.abs(startYX[1] - endYX[1]) == 1 && Math.abs(startYX[0] - endYX[0]) == 2;
        return !movesStraight && (!yOneXTwo || !yTwoXOne);
    }

}
