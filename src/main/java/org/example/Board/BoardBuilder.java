package org.example.Board;

import org.example.Figures.Figure;

public class BoardBuilder {

    Board board;

    public BoardBuilder(Board board) {
        this.board = board;
    }

    final String lowercaseRED = "\u001B[31m";
    final String uppercaseBLUE = "\u001B[34m";
    final String COLOR_RESET = "\u001B[0m";
    final String space = " ";
    final String horizontalSeparator = "   +-----+-----+-----+-----+-----+-----+-----+-----+\n";
    final String letters = "      a     b     c     d     e     f     g     h";
    final String newLine = "\n";

    public String buildUpperCaseBoard() {
        StringBuilder boardString = new StringBuilder();
        Object[][] boardArr = board.getBoard();
        boardString.append(letters);
        boardString.append(newLine);
        boardString.append(horizontalSeparator);
        for (int y = board.getBoard().length - 1; y >= 0; y--) {
            boardString.append(y);
            boardString.append(space);
            boardString.append(space);
            boardString.append("┊  ");
            for (int x = 0; x < board.getBoard()[0].length; x++) {
                if (boardArr[y][x] == null) {
                    boardString.append(space);
                } else if (boardArr[y][x] instanceof Figure) {
                    if (((Figure) boardArr[y][x]).isLowercase()) {
                        boardString.append(lowercaseRED);
                        boardString.append(boardArr[y][x].toString());
                        boardString.append(COLOR_RESET);
                    } else {
                        boardString.append(uppercaseBLUE);
                        boardString.append(boardArr[y][x].toString());
                        boardString.append(COLOR_RESET);
                    }
                }
                boardString.append("  ┊  ");
            }
            boardString.append(y);
            boardString.append("\n");
            boardString.append(horizontalSeparator);
        }
        boardString.append(letters);
        return boardString.toString();
    }

    public String buildLowerCaseBoard() {
        StringBuilder boardString = new StringBuilder();
        Object[][] boardArr = board.getBoard();
        boardString.append(letters);
        boardString.append(newLine);
        boardString.append(horizontalSeparator);
        for (int y = 0; y < board.getBoard().length; y++) {
            boardString.append(y);
            boardString.append(space);
            boardString.append(space);
            boardString.append("┊  ");
            for (int x = 0; x < board.getBoard()[0].length; x++) {
                if (boardArr[y][x] == null) {
                    boardString.append(space);
                } else if (boardArr[y][x] instanceof Figure) {
                    if (((Figure) boardArr[y][x]).isLowercase()) {
                        boardString.append(lowercaseRED);
                        boardString.append(boardArr[y][x].toString());
                        boardString.append(COLOR_RESET);
                    } else {
                        boardString.append(uppercaseBLUE);
                        boardString.append(boardArr[y][x].toString());
                        boardString.append(COLOR_RESET);
                    }
                }
                boardString.append("  ┊  ");
            }
            boardString.append(y);
            boardString.append("\n");
            boardString.append(horizontalSeparator);
        }
        boardString.append(letters);
        return boardString.toString();
    }
}
