package org.example.Board;

import org.example.Figures.*;

import static org.example.Symbols.Lowercase.*;
import static org.example.Symbols.Uppercase.*;

public class Board {

    private Object[][] board = {
            {new Rook(R), new Knight(N), new Bishop(B), new Queen(Q), new King(K), new Bishop(B), new Knight(N), new Rook(R)},
            {new Pawn(P), new Pawn(P), new Pawn(P), new Pawn(P), new Pawn(P), new Pawn(P), new Pawn(P), new Pawn(P)},
            {null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null},
            {new Pawn(p), new Pawn(p), new Pawn(p), new Pawn(p), new Pawn(p), new Pawn(p), new Pawn(p), new Pawn(p)},
            {new Rook(r), new Knight(n), new Bishop(b), new Queen(q), new King(k), new Bishop(b), new Knight(n), new Rook(r)}
    };

    public Object[][] getBoard() {
        return board;
    }

    public void moveFigure(int[][] from, int[][] to) {
    }

    public boolean hasFigure(int[] YX) {
        int y = YX[0];
        int x = YX[1];
        return board[y][x] != null;
    }

    public void setBoard(Object[][] board) {
        this.board = board;
    }

    public void removeFigure(int[] YX) {
        board[YX[0]][YX[1]] = null;
    }

    public void setFigure(int[] YX, Figure figure) {
        board[YX[0]][YX[1]] = null;
    }

}
