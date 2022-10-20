package org.example.Player;

import static org.example.Symbols.Lowercase.LOWERCASE;
import static org.example.Symbols.Uppercase.UPPERCASE;

public class Players {
    Player playerLower = new Player(LOWERCASE, "Red");
    Player playerUpper = new Player(UPPERCASE, "Blue");
    Player currentPlayer = playerLower;

    public void changeToNextPlayer() {
        if (currentPlayer == playerLower) {
            currentPlayer = playerUpper;
        } else {
            currentPlayer = playerLower;
        }
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public Player peekOpponent() {
        if (currentPlayer == playerLower) {
            return playerUpper;
        } else {
            return playerLower;
        }
    }
}
