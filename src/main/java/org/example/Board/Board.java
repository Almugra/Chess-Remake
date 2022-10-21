package org.example.Board;

import org.example.Figures.*;
import org.example.Input.Input;

import static org.example.Symbols.Lowercase.*;
import static org.example.Symbols.Uppercase.*;

public class Board {

    private Object[][] board = {
            {new Rook(R), new Knight(N), new Bishop(B), new Queen(Q), new King(K), new Bishop(B), new Knight(N), new Rook(R)},
            {new Pawn(P, this), new Pawn(P, this), new Pawn(P, this) , new Pawn(P, this) , new Pawn(P, this) , new Pawn(P, this) , new Pawn(P, this) , new Pawn(P, this)},
            {null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null},
            {new Pawn(p, this), new Pawn(p, this), new Pawn(p, this) , new Pawn(p, this) , new Pawn(p, this) , new Pawn(p, this) , new Pawn(p, this) , new Pawn(p, this)},
            {new Rook(r), new Knight(n), new Bishop(b), new Queen(q), new King(k), new Bishop(b), new Knight(n), new Rook(r)}
    };

    public Object[][] getBoard() {
        return board;
    }

    public void setBoard(Object[][] board) {
        this.board = board;
    }

    public Object matchSymbol(Object symbol) {
        if (symbol instanceof Bishop) {
            return ((Bishop) symbol).getSymbol();
        } else if (symbol instanceof King) {
            return ((King) symbol).getSymbol();
        } else if (symbol instanceof Knight) {
            return ((Knight) symbol).getSymbol();
        } else if (symbol instanceof Pawn) {
            return ((Pawn) symbol).getSymbol();
        } else if (symbol instanceof Queen) {
            return ((Queen) symbol).getSymbol();
        } else if (symbol instanceof Rook) {
            return ((Rook) symbol).getSymbol();
        }
        return new Queen(symbol);
    }

    public boolean canMove(int[][] fromPosToPos, Object figureType) {
        int[] from = fromPosToPos[0];
        int[] to = fromPosToPos[1];
        Between between = new Between(from, to, board);
        boolean movesEnemyFigure = board[from[0]][from[1]] != null && matchSymbol(board[from[0]][from[1]]).getClass() != figureType.getClass();
        boolean moresToAlreadyOwnedSpot = board[from[0]][from[1]] != null && matchSymbol(board[to[0]][to[1]]).getClass() == figureType.getClass();
        if (movesEnemyFigure) {
            System.out.println("You can only move your own figure!");
            return false;
        } else if (moresToAlreadyOwnedSpot) {
            System.out.println("You can't move to a spot you already have a figure on!");
            return false;
        } else if (!((Figure) board[from[0]][from[1]]).canMove(from, to)) {
            System.out.println("Your figure cant move like that!");
            return false;
        } else if (between.isFigureInBetween()) {
            System.out.println("You can't move to that spot because there is a figure between!");
            return false;
        } else if (false) {
            System.out.println("Cant move King because that position is in check!");
            return false;
        }
        return true;
    }

    public void moveFigure(Object playerFigureType) {
        Input input = new Input();
        int[][] fromTo;
        do {
            fromTo = input.requestInputs();
        } while (!canMove(fromTo, playerFigureType));
        int[] from = fromTo[0];
        int[] to = fromTo[1];
        setFigure(to, getFigure(to));
        removeFigure(from);
    }

    public Figure getFigure(int[] coordinates) {
        return (Figure) board[coordinates[0]][coordinates[1]];
    }

    public boolean hasFigure(int[] YX) {
        int y = YX[0];
        int x = YX[1];
        return board[y][x] != null;
    }

    public void removeFigure(int[] YX) {
        board[YX[0]][YX[1]] = null;
    }

    public void setFigure(int[] YX, Figure figure) {
        board[YX[0]][YX[1]] = null;
    }

}
