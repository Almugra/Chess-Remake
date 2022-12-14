package org.example.Board;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.example.Symbols.Lowercase.LOWERCASE;

class BoardTest {

    Board board = new Board();

    @Test
    void cantMoveEnemyFigure() {
        boolean actual = board.isMoveLegal(new int[][]{{0, 0}, {0, 1}}, LOWERCASE);
        Assertions.assertThat(actual).isFalse();
    }

    @Test
    void cantMoveBecauseAllyFigureIsOnGoalPosition() {
        boolean actual = board.isMoveLegal(new int[][]{{7, 0}, {7, 1}}, LOWERCASE);
        Assertions.assertThat(actual).isFalse();
    }

    @Test
    void cantMoveBecauseRookCantMoveLikeThat() {
        boolean actual = board.isMoveLegal(new int[][]{{7, 0}, {5, 2}}, LOWERCASE);
        Assertions.assertThat(actual).isFalse();
    }
}