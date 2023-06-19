package ru.shekhovtsov.xo.players;

import java.util.Random;
import java.util.Scanner;

public class ComputerPlayer implements Player {

    private final char symbol;
    private final int SIZE = 3;
    private final char EMPTY = ' ';
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
        return "Компьютер";
    }

    @Override
    public int[] makeMove() {
        while (true) {
            int row = RANDOM.nextInt(SIZE);
            int col = RANDOM.nextInt(SIZE);
            return new int[]{row, col};
        }
    }



}
