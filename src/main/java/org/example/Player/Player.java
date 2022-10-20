package org.example.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Player {
    private final Object symbol;
    private final String name;
    private List<Object> capturedPieces = new ArrayList<>();
    public Player(Object symbolCase, String name) {
        this.symbol = symbolCase;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Object getSymbol() {
        return symbol;
    }

    public void addCapturedPiece(Object piece) {
        capturedPieces.add(piece);
    }

    public List<Object> getCapturedPieces() {
        return capturedPieces;
    }

}
