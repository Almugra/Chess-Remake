package org.example.Figures;

import org.example.Symbols.Uppercase;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RookTest {

    Rook underTestClass;

    @BeforeEach
    void setUp() {
        underTestClass = new Rook(Uppercase.R);
    }

    @Test
    void rookCantMoveDiagonal() {
        int[] start = {3, 3};
        int[] end = {5, 5};
        boolean actual = underTestClass.canMove(start, end);
        assertThat(actual).isFalse();
    }

    @Test
    void rookCanMoveStraightUp() {
        int[] start = {7, 0};
        int[] end = {5, 0};
        boolean actual = underTestClass.canMove(start, end);
        assertThat(actual).isTrue();
    }
    @AfterEach
    void tearDown() {
        underTestClass = null;
    }
}