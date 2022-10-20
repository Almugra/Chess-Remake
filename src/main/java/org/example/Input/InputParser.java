package org.example.Input;

public class InputParser {

    public int[] inputToCoordinates(String input) {
        char[] xy = input.toCharArray();
        return new int[]{charToInt(xy[0]), charToInt(xy[1])};
    }

    public int charToInt(char c) {
        if (c - '0' <= 9) {
            return c - '0';
        } else if (c - 'a' <= 24) {
            return c - 'a';
        }
        return 9;
    }
}
