package org.example.Board;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.ObjectEnumerableAssert;
import org.example.Figures.Bishop;
import org.example.Figures.Pawn;
import org.example.Figures.Rook;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.example.Symbols.Uppercase.*;

class BetweenTest {

    Between between;
    Board b = new Board();

    @BeforeEach
    void setUp() {
        Object[][] bo = new Object[][]{
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
        };
        b.setBoard(bo);
    }

    @Test
    void rookCantMoveBecauseFigureIsBetween() {
        Object[][] board = b.getBoard();
        board[2][4] = new Rook(R);
        board[4][4] = new Pawn(P);
        between = new Between(new int[]{2, 4}, new int[]{6, 4}, board);

        boolean actual = between.isFigureInBetween();

        Assertions.assertThat(actual).isTrue();
    }

    @Test
    void rookCanMoveBecauseNoFigureBetween() {
        Object[][] board = b.getBoard();
        board[2][4] = new Rook(R);
        between = new Between(new int[]{2, 4}, new int[]{6, 4}, board);

        boolean actual = between.isFigureInBetween();

        Assertions.assertThat(actual).isFalse();
    }
    @Test
    void rookCantMoveBecauseFigureIsBetweenNegative() {
        Object[][] board = b.getBoard();
        board[6][4] = new Rook(R);
        board[4][4] = new Pawn(P);
        between = new Between(new int[]{6, 4}, new int[]{2, 4}, board);

        boolean actual = between.isFigureInBetween();

        Assertions.assertThat(actual).isTrue();
    }

    @Test
    void rookCantMoveSidewaysBecauseFigureBlocksPath() {
        Object[][] board = b.getBoard();
        board[4][2] = new Rook(R);
        board[4][4] = new Pawn(P);
        between = new Between(new int[]{4, 2}, new int[]{4, 6}, board);

        boolean actual = between.isFigureInBetween();

        Assertions.assertThat(actual).isTrue();
    }

    @Test
    void bishopCantMoveBecauseFigureIsBetween() {
        Object[][] board = b.getBoard();
        board[4][2] = new Bishop(B);
        board[6][4] = new Pawn(P);
        between = new Between(new int[]{4, 2}, new int[]{7, 5}, board);

        boolean actual = between.isFigureInBetween();

        Assertions.assertThat(actual).isTrue();
    }

    @Test
    void bishopCantMoveBecauseFigureIsBetweenNegative() {
        Object[][] board = b.getBoard();
        board[4][2] = new Bishop(B);
        board[2][4] = new Pawn(P);
        between = new Between(new int[]{4, 2}, new int[]{0, 6}, board);

        boolean actual = between.isFigureInBetween();

        Assertions.assertThat(actual).isTrue();
    }

    @Test
    void bishopCanMoveBecauseNoFigureIsInBetween() {
        Object[][] board = b.getBoard();
        board[4][2] = new Bishop(B);
        between = new Between(new int[]{4, 2}, new int[]{0, 6}, board);

        boolean actual = between.isFigureInBetween();

        Assertions.assertThat(actual).isFalse();
    }
    @AfterEach
    void tearDown() {
        between = null;
    }
}