package org.example.Symbols;

public enum Uppercase {
    UPPERCASE("Uppercase"),
    R("R"),
    N("N"),
    B("B"),
    Q("Q"),
    K("K"),
    P("P"),
    ;

    String name;

    Uppercase(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;

    }
}