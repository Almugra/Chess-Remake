package org.example.Symbols;

public enum Lowercase {
    LOWERCASE("Lowercase"),
    r("r"),
    n("n"),
    b("b"),
    q("q"),
    k("k"),
    p("p"),
    ;

    String name;

    Lowercase(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;

    }
}