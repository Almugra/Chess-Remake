package org.example.Board;

import org.assertj.core.api.Assertions;
import org.example.Figures.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.example.Symbols.Lowercase.*;
import static org.example.Symbols.Uppercase.*;

class CheckTest {

    Object[][] board;
    Board b = new Board();

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
    void cantMoveRookBecauseThatPutsMyKingInCheckmate() {
        board[0][0] = new King(K);
        board[0][1] = new Rook(R);
        board[0][3] = new Rook(r);
        board[0][4] = new King(k);
        int[] from = {0, 3};
        int[] to = {1, 3};
        b.setBoard(board);
        b.setLowerCaseKingPos(new int[]{0, 4});
        b.setLowerCaseKingPos(new int[]{0, 0});

        Figure rook = (Figure) board[0][3];

        boolean actual = rook.isKingCheck(from, to, b);

        Assertions.assertThat(actual).isTrue();
    }

    @Test
    void cantMoveKingBecauseThatPutsMyKingInCheckmate() {
        board[0][0] = new King(K);
        board[0][1] = new Rook(R);
        board[1][3] = new Rook(r);
        board[1][4] = new King(k);
        int[] from = {1, 4};
        int[] to = {0, 4};
        b.setBoard(board);

        Figure king = (Figure) board[1][4];

        boolean actual = king.isKingCheck(from, to, b);

        Assertions.assertThat(actual).isTrue();
    }

    @Test
    void cantMoveKingBecauseKingStillInCheck() {
        board[0][0] = new King(K);
        board[0][1] = new Rook(R);
        board[0][4] = new King(k);
        int[] from = {0, 4};
        int[] to = {0, 3};
        b.setBoard(board);

        Figure king = (Figure) board[0][4];

        boolean actual = king.isKingCheck(from, to, b);

        Assertions.assertThat(actual).isTrue();
    }

    @Test
    void canMoveKingBecauseResultIsNotInCheck() {
        board[0][0] = new King(K);
        board[0][1] = new Rook(R);
        board[0][3] = new Rook(r);
        board[0][4] = new King(k);
        int[] from = {0, 4};
        int[] to = {0, 5};
        b.setBoard(board);

        Figure king = (Figure) board[0][4];

        boolean actual = king.isKingCheck(from, to, b);

        Assertions.assertThat(actual).isFalse();
    }

    @Test
    void canMoveRookBecauseResultIsNotInCheck() {
        board[0][0] = new King(K);
        board[0][1] = new Rook(R);
        board[0][3] = new Rook(r);
        board[0][4] = new King(k);
        int[] from = {0, 3};
        int[] to = {0, 2};
        b.setBoard(board);

        Figure rook = (Figure) board[0][3];

        boolean actual = rook.isKingCheck(from, to, b);

        Assertions.assertThat(actual).isFalse();
    }

    @Test
    void canMovePawnBecauseKingNotInCheck() {
        Board b = new Board();
        int[] from = {6, 4};
        int[] to = {4, 4};
        Pawn pawn = new Pawn(p);
        boolean actual = pawn.isKingCheck(from, to, b);

        Assertions.assertThat(actual).isFalse();
    }

    @Test
    void rookCanMoveBetweenAttackingFigureAndKingToStopCheck() {
        board[0][0] = new King(K);
        board[1][0] = new Rook(R);
        board[5][1] = new Rook(r);
        board[7][0] = new King(k);
        b.setBoard(board);
        b.setLowerCaseKingPos(new int[]{7, 0});
        EndgameActions gameActions = new EndgameActions(b.getKingPosition(LOWERCASE), b);

        int[] pos = gameActions.getFigureTargetingKingPos(LOWERCASE);
        System.out.println(Arrays.toString(pos));
        boolean actual = gameActions.canFigureMoveBetweenAttackerAndKing(LOWERCASE, pos);

        Assertions.assertThat(actual).isTrue();
    }

    @Test
    void rookCantMoveBetweenAttackingFigureAndKingToStopCheck() {
        board[0][0] = new King(K);
        board[1][0] = new Rook(R);
        board[7][1] = new Rook(r);
        board[7][0] = new King(k);
        b.setBoard(board);
        b.setLowerCaseKingPos(new int[]{7, 0});
        EndgameActions gameActions = new EndgameActions(b.getLowerCaseKingPos(), b);

        int[] pos = gameActions.getFigureTargetingKingPos(LOWERCASE);
        boolean actual = gameActions.canFigureMoveBetweenAttackerAndKing(LOWERCASE, pos);

        Assertions.assertThat(actual).isFalse();
    }

    @Test
    void kingIsTargetedByEnemyFigure() {
        board[0][0] = new King(K);
        board[1][0] = new Rook(R);
        board[5][1] = new Rook(r);
        board[7][0] = new King(k);
        b.setBoard(board);
        b.setLowerCaseKingPos(new int[]{7, 0});
        EndgameActions gameActions = new EndgameActions(new int[]{7, 0}, b);

        int[] actual = gameActions.getFigureTargetingKingPos(LOWERCASE);

        Assertions.assertThat(actual).isEqualTo(new int[]{1, 0});
    }

    @Test
    void queenCanTargetRook() {
        board[0][0] = new King(K);
        board[1][0] = new Rook(R);
        board[5][4] = new Queen(q);
        board[7][0] = new King(k);
        b.setBoard(board);
        b.setLowerCaseKingPos(new int[]{7, 0});
        EndgameActions gameActions = new EndgameActions(new int[]{7, 0}, b);

        int[] enemyTargetingMyKingPosition = gameActions.getFigureTargetingKingPos(LOWERCASE);
        boolean actual = gameActions.canFigureAttackEnemy(enemyTargetingMyKingPosition, LOWERCASE);

        Assertions.assertThat(actual).isTrue();
    }

    @Test
    void QueenCanCheckMateUpperCaseKing() {
        Object[][] ba = b.getBoard();
        ba[2][4] = new Pawn(P);
        ba[1][4] = null;

        ba[4][6] = new Pawn(p);
        ba[5][5] = new Pawn(p);
        ba[6][5] = null;
        ba[6][6] = null;
        b.setBoard(ba);
        BoardBuilder builder = new BoardBuilder(b);
        System.out.println(builder.buildLowerCaseBoard());
        boolean actual = b.isMoveLegal(new int[][]{{0, 3}, {4, 7}}, UPPERCASE);
        Assertions.assertThat(actual).isTrue();
    }

    @Test
    void kingCantMoveToAnyPositionBecauseTheyAreAllBlocked() {
        EndgameActions gameActions = new EndgameActions(new int[]{0, 4}, b);
        boolean canKingMoveToAnyPosition = gameActions.canKingMoveToAnyPosition();

        Assertions.assertThat(canKingMoveToAnyPosition).isFalse();
    }

    @Test
    void kingCanMoveToAnyPositions() {
        b.removeFigure(new int[]{1,4});
        EndgameActions gameActions = new EndgameActions(new int[]{0, 4}, b);
        boolean canKingMoveToAnyPosition = gameActions.canKingMoveToAnyPosition();

        Assertions.assertThat(canKingMoveToAnyPosition).isTrue();
    }

    @Test
    void lowerCaseKingIsCheckMate() {
        board[7][7] = new Queen(Q);
        board[3][7] = new Rook(R);
        board[0][4] = new King(K);
        board[6][5] = new Pawn(p);
        board[6][6] = new Pawn(p);
        board[7][5] = new Rook(r);
        board[7][6] = new King(k);
        b.setBoard(board);
        b.setLowerCaseKingPos(new int[]{7, 6});
        b.setUpperCaseKingPos(new int[]{0, 4});
        EndgameActions gameActions = new EndgameActions(b.getKingPosition(LOWERCASE), b);

        int[] figureTargetingKing = gameActions.getFigureTargetingKingPos(LOWERCASE);
        boolean figureCanAttackEnemyFigure = gameActions.canFigureAttackEnemy(figureTargetingKing, LOWERCASE);
        boolean figureCanMoveBetweenAttackerAndKing = gameActions.canFigureMoveBetweenAttackerAndKing(LOWERCASE, figureTargetingKing);
        System.out.println(figureCanAttackEnemyFigure);
        System.out.println(figureCanMoveBetweenAttackerAndKing);
        boolean isLowerCaseKingCheck = figureTargetingKing != null
                                       && !figureCanMoveBetweenAttackerAndKing
                                       && !figureCanAttackEnemyFigure;
        Assertions.assertThat(isLowerCaseKingCheck).isTrue();
    }

    @Test
    void checkmateTest() {
        Object[][] ba = b.getBoard();
        ba[0][4] = null;
        ba[1][4] = new King(K);
        ba[3][4] = new Pawn(P);

        ba[3][6] = new Queen(q);
        ba[4][4] = new Pawn(p);
        ba[6][4] = null;
        ba[7][3] = null;
        b.setBoard(ba);
        BoardBuilder builder = new BoardBuilder(b);
        System.out.println(builder.buildLowerCaseBoard());
        EndgameActions gameActions = new EndgameActions(new int[]{1, 4}, b);
        int[] figureTargetingKing = gameActions.getFigureTargetingKingPos(UPPERCASE);
        boolean figureCanMoveBetweenAttackerAndKing = gameActions.canFigureMoveBetweenAttackerAndKing(UPPERCASE, figureTargetingKing);
        boolean figureCanAttackEnemyFigure = gameActions.canFigureAttackEnemy(figureTargetingKing, UPPERCASE);
        System.out.println(Arrays.toString(figureTargetingKing));
        System.out.println(figureCanMoveBetweenAttackerAndKing);
        System.out.println(figureCanAttackEnemyFigure);
        boolean actual = b.isMoveLegal(new int[][]{{1, 4}, {0, 4}}, UPPERCASE);
        Assertions.assertThat(actual).isTrue();
    }
}