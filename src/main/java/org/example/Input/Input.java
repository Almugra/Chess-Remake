package org.example.Input;

import java.util.Scanner;

public class Input extends InputParser {

    public boolean validateInput(String input) {
        return false;
    }

    public String requestIntInput() {
        Scanner scn = new Scanner(System.in);
        return scn.next();
    }

}
