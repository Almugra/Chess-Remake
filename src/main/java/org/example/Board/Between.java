package org.example.Board;

public class Between {
    int[] startYX;
    int[] endYX;
    Object[][] board;

    public Between(int[] from, int[] to, Object[][] board) {
        this.startYX = from;
        this.endYX = to;
        this.board = board;
    }

    public int getRunValueForBoard(int coordinate, int runValue) {
        if (startYX[coordinate] == endYX[coordinate]) {
            return startYX[coordinate];
        } else if (startYX[coordinate] > endYX[coordinate]) {
            return startYX[coordinate] - runValue;
        } else {
            return startYX[coordinate] + runValue;
        }
    }

    public boolean isFigureInBetween() {
        int end;
        if (Math.abs(startYX[1] - endYX[1]) == 0) {
            end = Math.abs(startYX[0] - endYX[0]) - 1;
        } else {
            end = Math.abs(startYX[1] - endYX[1]) - 1;
        }
        for (int i = 1; i <= end; i++) {
            int boardRunValueX = getRunValueForBoard(1, i);
            int boardRunValueY = getRunValueForBoard(0, i);
            if (board[boardRunValueY][boardRunValueX] != null) {
                return true;
            }
        }
        return false;
    }
}
