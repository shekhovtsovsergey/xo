package ru.shekhovtsov.xo.players;

public class ComputerPlayer implements Player {

    private final char symbol;

    public ComputerPlayer(char symbol) {
        this.symbol = symbol;
    }

    @Override
    public char getSymbol() {
        return symbol;
    }
    @Override
    public String getName() {
        return "Компьютер";
    }
}
