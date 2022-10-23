package org.example.Board;

import org.assertj.core.api.Assertions;
import org.example.Figures.Figure;
import org.example.Figures.King;
import org.example.Figures.Pawn;
import org.example.Figures.Rook;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.example.Symbols.Lowercase.*;
import static org.example.Symbols.Uppercase.*;

class CheckTest {

    Object[][] board;
    Board b = new Board();

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
    void cantMoveRookBecauseThatPutsMyKingInCheckmate() {
        board[0][0] = new King(K);
        board[0][1] = new Rook(R);
        board[0][3] = new Rook(r);
        board[0][4] = new King(k);
        int[] from = {0, 3};
        int[] to = {1, 3};
        b.setBoard(board);
        b.setLowerCaseKingPos(new int[]{0,4});
        b.setLowerCaseKingPos(new int[]{0,0});

        Figure rook = (Figure) board[0][3];

        boolean actual = rook.isKingCheck(from, to, b);

        Assertions.assertThat(actual).isTrue();
    }

    @Test
    void cantMoveKingBecauseThatPutsMyKingInCheckmate() {
        board[0][0] = new King(K);
        board[0][1] = new Rook(R);
        board[1][3] = new Rook(r);
        board[1][4] = new King(k);
        int[] from = {1, 4};
        int[] to = {0, 4};
        b.setBoard(board);

        Figure king = (Figure) board[1][4];

        boolean actual = king.isKingCheck(from, to, b);

        Assertions.assertThat(actual).isTrue();
    }

    @Test
    void canMoveKingBecauseResultIsNotInCheck() {
        board[0][0] = new King(K);
        board[0][1] = new Rook(R);
        board[0][3] = new Rook(r);
        board[0][4] = new King(k);
        int[] from = {0, 4};
        int[] to = {0, 5};
        b.setBoard(board);

        Figure king = (Figure) board[0][4];

        boolean actual = king.isKingCheck(from, to, b);

        Assertions.assertThat(actual).isFalse();
    }

    @Test
    void canMoveRookBecauseResultIsNotInCheck() {
        board[0][0] = new King(K);
        board[0][1] = new Rook(R);
        board[0][3] = new Rook(r);
        board[0][4] = new King(k);
        int[] from = {0, 3};
        int[] to = {0, 2};
        b.setBoard(board);

        Figure rook = (Figure) board[0][3];

        boolean actual = rook.isKingCheck(from, to, b);

        Assertions.assertThat(actual).isFalse();
    }

    @Test
    void canMovePawnBecauseKingNotInCheck() {
        Board b = new Board();
        BoardBuilder builder = new BoardBuilder(b);
        int[][] fromTo = {{6,4}, {4, 4}};
        int[] from = {6,4};
        int[] to = {4, 4};
        Pawn pawn = new Pawn(p);
        boolean actual = pawn.isKingCheck(from, to, b);
        System.out.println(builder.buildLowerCaseBoard());

        Assertions.assertThat(actual).isFalse();
    }
}