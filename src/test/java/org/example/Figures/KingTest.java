package org.example.Figures;

import org.example.Symbols.Uppercase;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.example.Symbols.Uppercase.B;
import static org.example.Symbols.Uppercase.UPPERCASE;
import static org.junit.jupiter.api.Assertions.*;

class KingTest {
    King underTestClass;

    @BeforeEach
    void setUp() {
        underTestClass = new King(Uppercase.K);
    }

    @Test
    void kingCantMoveTwoPositions() {
    }

    @AfterEach
    void tearDown() {
        underTestClass = null;
    }
}