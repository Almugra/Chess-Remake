package org.example.Figures;

import org.assertj.core.api.Assertions;
import org.example.Board.Board;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.example.Symbols.Lowercase.p;
import static org.example.Symbols.Uppercase.P;

class PawnTest {

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
    void pawnCantMove3Up() {
        board[6][0] = new Pawn(P);
        b.setBoard(board);
        Pawn p = (Pawn) board[6][0];
        boolean actual = p.canMove(new int[]{6, 0}, new int[]{3, 0}, b);

        Assertions.assertThat(actual).isFalse();
    }

    @Test
    void pawnCantMoveDiagonalBecauseThereIsNoFigure() {
        board[6][0] = new Pawn(P);
        b.setBoard(board);
        Pawn p = (Pawn) board[6][0];
        boolean actual = p.canMove(new int[]{6, 0}, new int[]{5, 1},b);

        Assertions.assertThat(actual).isFalse();
    }

    @Test
    void pawnCanMoveDiagonalBecauseThereIsAFigure() {
        board[6][0] = new Pawn(p);
        board[5][1] = new Pawn(p);
        b.setBoard(board);
        Pawn p = (Pawn) board[6][0];
        boolean actual = p.canMove(new int[]{6, 0}, new int[]{5, 1}, b);

        Assertions.assertThat(actual).isTrue();
    }

    @Test
    void pawnCantMoveTwoBecausePawnAlreadyMoved() {
        board[5][0] = new Pawn(P);
        b.setBoard(board);
        Pawn p = (Pawn) board[5][0];
        boolean actual = p.canMove(new int[]{5, 0}, new int[]{3, 0}, b);

        Assertions.assertThat(actual).isFalse();
    }

    @Test
    void pawnCanMoveTwoBecausePawnHasNotMovedBefore() {
        board[6][0] = new Pawn(p);
        b.setBoard(board);
        Pawn p = (Pawn) board[6][0];
        boolean actual = p.canMove(new int[]{6, 0}, new int[]{4, 0}, b);

        Assertions.assertThat(actual).isTrue();
    }
}