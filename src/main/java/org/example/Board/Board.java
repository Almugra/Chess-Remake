package org.example.Board;

import org.example.Figures.*;
import org.example.Input.Input;
import org.example.Symbols.Lowercase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.example.Symbols.Lowercase.*;
import static org.example.Symbols.Uppercase.*;

public class Board {

    public boolean isCheckmate = false;
    int[] lowerCaseKingPos = {7, 4};
    int[] upperCaseKingPos = {0, 4};
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

    public int[] getLowerCaseKingPos() {
        return lowerCaseKingPos;
    }

    public void setLowerCaseKingPos(int[] lowerCaseKingPos) {
        this.lowerCaseKingPos = lowerCaseKingPos;
    }

    public int[] getUpperCaseKingPos() {
        return upperCaseKingPos;
    }

    public void setUpperCaseKingPos(int[] upperCaseKingPos) {
        this.upperCaseKingPos = upperCaseKingPos;
    }

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

    public boolean canMove(int[][] fromPosToPos, Object playerFigureType) {
        int[] from = fromPosToPos[0];
        int[] to = fromPosToPos[1];
        Between between = new Between(from, to, board);
        boolean movesNull = board[from[0]][from[1]] == null;
        boolean movesEnemyFigure = board[from[0]][from[1]] != null && matchSymbol(board[from[0]][from[1]]).getClass() != playerFigureType.getClass();
        boolean moresToAlreadyOwnedSpot = board[from[0]][from[1]] != null && matchSymbol(board[to[0]][to[1]]).getClass() == playerFigureType.getClass();
        if (movesNull) {
            System.out.println("Can't move empty position!");
            return false;
        } else if (movesEnemyFigure) {
            System.out.println("You can only move your own figure!");
            return false;
        } else if (moresToAlreadyOwnedSpot) {
            System.out.println("You can't move to a spot you already have a figure on!");
            return false;
        } else if (!((Figure) board[from[0]][from[1]]).canMove(from, to, this)) {
            System.out.println("Your figure cant move like that!");
            return false;
        } else if (!(board[from[0]][from[1]] instanceof Knight) && between.isFigureInBetween()) {
            System.out.println("You can't move to that spot because there is a figure between!");
            return false;
        } else if (((Figure) board[from[0]][from[1]]).isKingCheck(from, to, this)) {
            System.out.println("Cant move your figure because that puts your king in check!");
            return false;
        }
        return true;
    }

    public int[] getKingPosition(Object symbol) {
        if (symbol.getClass() == Lowercase.class) {
            return lowerCaseKingPos;
        } else {
            return upperCaseKingPos;
        }
    }

    public void moveFigure(Object playerFigureType) {
        Input input = new Input();
        int[][] fromTo;
        do {
            fromTo = input.requestInputs();
        } while (!canMove(fromTo, playerFigureType));
        int[] from = fromTo[0];
        int[] to = fromTo[1];
        if (board[from[0]][from[1]] instanceof King) {
            if (((King) board[from[0]][from[1]]).isLowercase()) {
                lowerCaseKingPos = to;
            } else {
                upperCaseKingPos = to;
            }
        }
//        setFigure(to, getFigure(from));
//        removeFigure(from);
    }

    public List<List<Integer>> getListOfSymbolPositions(Object symbol) {
        List<List<Integer>> poss = new ArrayList<>();
        for (int y = 0; y <= 7; y++) {
            for (int x = 0; x <= 7; x++) {
                if (board[y][x] instanceof Figure && ((Figure) board[y][x]).getSymbol().getClass() == symbol.getClass()) {
                    poss.add(Arrays.asList(y, x));
                }
            }
        }
        return poss;
    }

    public Figure getFigure(int[] coordinates) {
        return (Figure) board[coordinates[0]][coordinates[1]];
    }

    public void removeFigure(int[] YX) {
        board[YX[0]][YX[1]] = null;
    }

    public void setFigure(int[] YX, Figure figure) {
        board[YX[0]][YX[1]] = figure;
    }

}
