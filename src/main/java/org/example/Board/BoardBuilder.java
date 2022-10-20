package org.example.Board;

import org.example.Figures.Figure;

public class BoardBuilder {

    final String lowercaseRED = "\u001B[31m";
    final String uppercaseBLUE = "\u001B[34m";
    final String COLOR_RESET = "\u001B[0m";
    final String space = " ";
    final String horizontalSeparator = "   +-----+-----+-----+-----+-----+-----+-----+-----+\n";
    final String letters = "      a     b     c     d     e     f     g     h";
    final String newLine = "\n";
    Board board;

    public BoardBuilder(Board board) {
        this.board = board;
    }

    private static void postNumberCoordinates(StringBuilder boardString, int y) {
        boardString.append(y);
        boardString.append("\n");
    }

    public String buildUpperCaseBoard() {
        StringBuilder boardString = new StringBuilder();
        Object[][] boardArr = board.getBoard();
        boardString.append(letters);
        boardString.append(newLine);
        boardString.append(horizontalSeparator);
        for (int y = 7; y >= 0; y--) {
            buildRow(boardString, boardArr, y);
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
        for (int y = 0; y <= 7; y++) {
            buildRow(boardString, boardArr, y);
        }
        boardString.append(letters);
        return boardString.toString();
    }

    private void buildRow(StringBuilder boardString, Object[][] boardArr, int y) {
        preNumberCoordinates(boardString, y);
        buildField(boardString, boardArr, y);
        postNumberCoordinates(boardString, y);
        boardString.append(horizontalSeparator);
    }

    private void buildField(StringBuilder boardString, Object[][] boardArr, int y) {
        for (int x = 0; x < board.getBoard()[0].length; x++) {
            if (boardArr[y][x] == null) {
                boardString.append(space);
            } else if (boardArr[y][x] instanceof Figure) {
                String figureSymbol = boardArr[y][x].toString();
                if (((Figure) boardArr[y][x]).isLowercase()) {
                    boardString.append(lowercaseRED);
                    boardString.append(figureSymbol);
                    boardString.append(COLOR_RESET);
                } else {
                    boardString.append(uppercaseBLUE);
                    boardString.append(figureSymbol);
                    boardString.append(COLOR_RESET);
                }
            }
            boardString.append("  ┊  ");
        }
    }

    private void preNumberCoordinates(StringBuilder boardString, int y) {
        boardString.append(y);
        boardString.append(space);
        boardString.append(space);
        boardString.append("┊  ");
    }
}
