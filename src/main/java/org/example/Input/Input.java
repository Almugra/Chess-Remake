package org.example.Input;

import java.util.Arrays;
import java.util.Scanner;

public class Input extends InputParser {

    public int[] requestInput() {
        Scanner scn = new Scanner(System.in);
        return inputToCoordinates(scn.next());
    }
    
    public boolean outOfBound(int[] coordinates) {
        return coordinates[0] > 7 || coordinates[0] < 0 || coordinates[1] > 7 || coordinates[1] < 0;
    }

    public int[][] requestInputs() {
        int[] start;
        int[] end;
        while (true) {
            System.out.print("From(YX): ");
            start = requestInput();
            System.out.print("To(YX): ");
            end = requestInput();
            if (Arrays.equals(start, end)) {
                System.out.println("Can't move to the same position!");
                continue;
            } else if (outOfBound(start) || outOfBound(end)) {
                System.out.println("Coordinates out of bound!");
                continue;
            }
            break;
        }
        return new int[][]{start, end};
    }

}
