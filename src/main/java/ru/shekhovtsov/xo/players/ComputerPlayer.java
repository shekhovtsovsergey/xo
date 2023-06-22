package ru.shekhovtsov.xo.players;

import ru.shekhovtsov.xo.game.Board;

import java.util.Random;


public class ComputerPlayer implements Player {

    private final char symbol = '0';
    private final int SIZE = 3;
    private final Random RANDOM = new Random();
    private char[][] field = new char[SIZE][SIZE];

    @Override
    public char getSymbol() {
        return symbol;
    }
    @Override
    public String getName() {
        return "Computer";
    }
    @Override
    public void move(Board board) {
            int row = RANDOM.nextInt(SIZE);
            int col = RANDOM.nextInt(SIZE);
            board.makeMove(row, col, this);
    }
}
