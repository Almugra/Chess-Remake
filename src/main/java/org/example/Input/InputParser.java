package org.example.Input;

public class InputParser {

    public int[] inputToCoordinates(String input) {
        char[] yx = input.toCharArray();
        return new int[]{charToInt(yx[1]), charToInt(yx[0])};
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
