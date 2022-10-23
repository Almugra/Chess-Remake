package org.example.Figures;

import org.example.Board.Between;
import org.example.Board.Board;
import org.example.Board.BoardBuilder;
import org.example.Symbols.Lowercase;
import org.example.Symbols.Uppercase;

import static org.example.Symbols.Lowercase.*;
import static org.example.Symbols.Uppercase.*;

public class Rook implements Figure {
    public Object symbol;

    public Rook(Object symbol) {
        this.symbol = symbol;
    }

    @Override
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
    public boolean canMove(int[] startYX, int[] endYX, Board board) {
        return Math.abs(startYX[0] - endYX[0]) == 0 && Math.abs(startYX[1] - endYX[1]) != 0
               || Math.abs(startYX[1] - endYX[1]) == 0 && Math.abs(startYX[0] - endYX[0]) != 0;
    }

    @Override
    public boolean isKingCheck(int[] from, int[] to, Board board) {
        int[] relevantKingPos;
        if (symbol.getClass() == Lowercase.class) {
            relevantKingPos = board.getLowerCaseKingPos();
        } else {
            relevantKingPos = board.getUpperCaseKingPos();
        }
        Between between;
        Board newBoard = new Board();
        newBoard.setBoard(board.getBoard());
        newBoard.setFigure(to, this);
        newBoard.removeFigure(from);
        Object[][] b = newBoard.getBoard();
        for (int y = 0; y <= 7; y++) {
            for (int x = 0; x <= 7; x++) {
                if (b[y][x] instanceof Figure && ((Figure) b[y][x]).getSymbol().getClass() != symbol.getClass()) {
                    between = new Between(new int[]{y,x}, relevantKingPos, b);
                    if (((Figure) b[y][x]).canMove(new int[]{y,x}, relevantKingPos, newBoard) && !between.isFigureInBetween()) {
                        System.out.println("Rook");
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
