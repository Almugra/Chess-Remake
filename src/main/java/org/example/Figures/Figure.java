package org.example.Figures;

import org.example.Board.Board;

public interface Figure {

    Object getSymbol();

    boolean isLowercase();

    boolean canMove(int[] startYX, int[] endYX, Board board);

    boolean isKingCheck(int[] startYX, int[] endYX, Board board);
}
