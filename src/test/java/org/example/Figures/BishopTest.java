package org.example.Figures;

import org.example.Board.Board;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.example.Symbols.Uppercase.B;

class BishopTest {

    Bishop underTestClass;
    Board board = new Board();

    @BeforeEach
    void setUp() {
        underTestClass = new Bishop(B);
    }

    @Test
    void bishopCantMoveHorizontal() {
        int[] start = {3, 3};
        int[] end = {5, 3};
        boolean actual = underTestClass.canMove(start, end, board);
        assertThat(actual).isFalse();
    }

    @Test
    void bishopCantMoveVertical() {
        int[] start = {3, 3};
        int[] end = {3, 5};
        boolean actual = underTestClass.canMove(start, end, board);
        assertThat(actual).isFalse();
    }

    @Test
    void bishopCantMoveInSquiggle() {
        int[] start = {3, 3};
        int[] end = {5, 2};
        boolean actual = underTestClass.canMove(start, end, board);
        assertThat(actual).isFalse();
    }

    @AfterEach
    void tearDown() {
        underTestClass = null;
    }
}