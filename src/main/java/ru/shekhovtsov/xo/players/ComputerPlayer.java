package ru.shekhovtsov.xo.players;

import ru.shekhovtsov.xo.game.Board;

import java.util.Random;


public class ComputerPlayer implements Player {

    private char symbol;
    private final int SIZE = 3;
    private final Random RANDOM = new Random();
    private char[][] field = new char[SIZE][SIZE];

    public ComputerPlayer(char symbol) {
        this.symbol = symbol;
    }

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
        while (true) {
            int row = RANDOM.nextInt(SIZE);
            int col = RANDOM.nextInt(SIZE);
            if (board.makeMove(row, col, this)) {
                break;
            } else {
                System.out.println("Invalid move, try again.");
            }
        }
    }
}
