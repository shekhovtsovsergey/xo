package ru.shekhovtsov.xo.players;

public class HumanPlayer implements Player {

    private final String name;
    private final char symbol;

    public HumanPlayer(String name, char symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    @Override
    public char getSymbol() {
        return symbol;
    }

    @Override
    public String getName() {
        return name;
    }
}
