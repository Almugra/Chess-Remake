package org.example.Board;

import org.assertj.core.api.Assertions;
import org.example.Figures.King;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.example.Symbols.Lowercase.*;
import static org.example.Symbols.Uppercase.*;

class StalemateTest {

    Board b = new Board();
    Object[][] board;

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
    void Diagram1() {
        //https://i.imgur.com/oQWepJo.png
        board[0][6] = new King(K);
        board[1][6] = new King(p);
        board[2][6] = new King(k);
        b.setBoard(board);
        Draw draw = new Draw(b, UPPERCASE);

        boolean isStalemate = draw.isStalemate();

        Assertions.assertThat(isStalemate).isTrue();
    }

    @Test
    void Diagram2() {
        //https://i.imgur.com/YsZ0pAb.png
        board[0][0] = new King(K);
        board[0][1] = new King(B);
        board[0][7] = new King(r);
        board[2][1] = new King(k);
        b.setBoard(board);
        Draw draw = new Draw(b, UPPERCASE);

        boolean isStalemate = draw.isStalemate();

        Assertions.assertThat(isStalemate).isTrue();
    }

    @Test
    void Diagram3() {
        //https://i.imgur.com/8k9TksA.png
        board[3][6] = new King(k);
        board[5][1] = new King(Q);
        board[6][0] = new King(P);
        board[7][0] = new King(K);
        b.setBoard(board);
        Draw draw = new Draw(b, UPPERCASE);

        boolean isStalemate = draw.isStalemate();

        Assertions.assertThat(isStalemate).isTrue();
    }

    @Test
    void Diagram4() {
        //https://i.imgur.com/vnM4t2A.png
        board[3][6] = new King(k);
        board[5][1] = new King(Q);
        board[6][0] = new King(P);
        board[7][0] = new King(K);
        b.setBoard(board);
        Draw draw = new Draw(b, UPPERCASE);

        boolean isStalemate = draw.isStalemate();

        Assertions.assertThat(isStalemate).isTrue();
    }
}