package org.example.Figures;

import org.assertj.core.api.Assertions;
import org.example.Symbols.Uppercase;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.example.Symbols.Uppercase.*;
import static org.junit.jupiter.api.Assertions.*;

class BishopTest {

    Bishop underTestClass;

    @BeforeEach
    void setUp() {
        underTestClass = new Bishop(B);
    }

    @Test
    void bishopCantMoveHorizontal() {
        int[] start = {3, 3};
        int[] end = {5, 3};
        boolean actual = underTestClass.canMove(start, end);
        assertThat(actual).isFalse();
    }

    @Test
    void bishopCantMoveVertical() {
        int[] start = {3, 3};
        int[] end = {3, 5};
        boolean actual = underTestClass.canMove(start, end);
        assertThat(actual).isFalse();
    }

    @Test
    void bishopDoesntMoveDiagonal() {
        int[] start = {3, 3};
        int[] end = {5, 2};
        boolean actual = underTestClass.canMove(start, end);
        assertThat(actual).isFalse();
    }

    @AfterEach
    void tearDown() {
        underTestClass = null;
    }
}