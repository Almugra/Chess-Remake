package org.example.Figures;

import org.example.Board.Board;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.example.Symbols.Uppercase.K;

class KingTest {
    King underTestClass;
    Board board = new Board();

    @BeforeEach
    void setUp() {
        underTestClass = new King(K);
    }

    @Test
    void kingCantMoveTwoPositions() {
        int[] start = {3, 3};
        int[] end = {1, 5};
        boolean actual = underTestClass.canMove(start, end, board);
        assertThat(actual).isFalse();
    }

    @AfterEach
    void tearDown() {
        underTestClass = null;
    }
}