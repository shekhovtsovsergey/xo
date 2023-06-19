package ru.shekhovtsov.xo.players;

import java.util.Scanner;

public class HumanPlayer implements Player {

    private final String name;
    private final char symbol;
    private final int SIZE = 3;
    private final char EMPTY = ' ';
    private final Scanner SCANNER = new Scanner(System.in);
    private char[][] field = new char[SIZE][SIZE];

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

    @Override
    public int[] makeMove() {
        while (true) {
            System.out.print(getName() + ", введите координаты (строка [x], колонка [y]) разделитель пробел между координатами: ");
            int row = SCANNER.nextInt() - 1;
            int col = SCANNER.nextInt() - 1;
                return new int[]{row, col};
        }
    }

}
