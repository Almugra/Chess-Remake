package org.example.Figures;

import org.example.Symbols.Uppercase;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class KingTest {
    King underTestClass;

    @BeforeEach
    void setUp() {
        underTestClass = new King(Uppercase.K);
    }

    @Test
    void kingCantMoveTwoPositions() {
        int[] start = {3, 3};
        int[] end = {1, 5};
        boolean actual = underTestClass.canMove(start, end);
        assertThat(actual).isFalse();
    }

    @AfterEach
    void tearDown() {
        underTestClass = null;
    }
}