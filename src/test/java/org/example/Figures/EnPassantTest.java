package org.example.Figures;

import org.assertj.core.api.Assertions;
import org.example.Board.Board;
import org.example.Board.BoardBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static java.util.Arrays.asList;
import static org.example.Symbols.Lowercase.p;
import static org.example.Symbols.Uppercase.P;

class EnPassantTest {
    Board b = new Board();
    Object[][] board;

    @BeforeEach
    void setUp() {
        board = new Object[][]{
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
        };
    }

    @Test
    void pawnCanMoveEnPassant() {
        board[3][0] = new Pawn(P);
        board[3][1] = new Pawn(p);
        b.setBoard(board);

        Pawn pawn = (Pawn) board[3][0];
        pawn.addMoveToMoveHistory(asList(asList(1, 0), asList(3, 0)));
        Pawn pawn2 = (Pawn) board[3][1];
        boolean actual = pawn2.canMoveEnPassant(new int[]{3, 1}, new int[]{2, 0}, b);
        Assertions.assertThat(actual).isTrue();
    }

    @Test
    void pawnCanMoveEnPassant2() {
        board[4][0] = new Pawn(p);
        board[4][1] = new Pawn(P);
        b.setBoard(board);

        Pawn pawn = (Pawn) board[4][0];
        pawn.addMoveToMoveHistory(asList(asList(6, 0), asList(4, 0)));
        Pawn pawn2 = (Pawn) board[4][1];
        boolean actual = pawn2.canMove(new int[]{4, 1}, new int[]{5, 0}, b);
        Assertions.assertThat(actual).isTrue();
    }

    @Test
    void pawnCantMoveEnPassant() {
        board[4][0] = new Pawn(p);
        board[4][1] = new Pawn(P);
        b.setBoard(board);

        Pawn pawn = (Pawn) board[4][0];
        pawn.addMoveToMoveHistory(asList(asList(6, 0), asList(5, 0)));
        pawn.addMoveToMoveHistory(asList(asList(5, 0), asList(4, 0)));
        Pawn pawn2 = (Pawn) board[4][1];
        boolean actual = pawn2.canMove(new int[]{4, 1}, new int[]{5, 0}, b);
        Assertions.assertThat(actual).isFalse();
    }
}