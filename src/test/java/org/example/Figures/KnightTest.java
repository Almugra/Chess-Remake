package org.example.Figures;

import org.example.Board.Board;
import org.example.Symbols.Uppercase;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class KnightTest {

    Knight underTestClass;
    Board board = new Board();

    @BeforeEach
    void setUp() {
        underTestClass = new Knight(Uppercase.N);
    }

    @Test
    void knightCantMoveHorizontal() {
        int[] start = {3, 3};
        int[] end = {5, 3};
        boolean actual = underTestClass.canMove(start, end, board);
        assertThat(actual).isFalse();
    }

    @Test
    void knightCantMoveVertical() {
        int[] start = {3, 3};
        int[] end = {3, 5};
        boolean actual = underTestClass.canMove(start, end, board);
        assertThat(actual).isFalse();
    }

    @Test
    void knightCanMoveLikeAKnight() {
        int[] start = {3, 3};
        int[] end = {2, 5};
        boolean actual = underTestClass.canMove(start, end, board);
        assertThat(actual).isTrue();
    }

    @AfterEach
    void tearDown() {
        underTestClass = null;
    }
}