package ru.shekhovtsov.xo.players;

import ru.shekhovtsov.xo.game.Board;

import java.util.Scanner;

public class HumanPlayer implements Player {

    private final String name;
    private final char symbol = 'X';
    private final Scanner SCANNER = new Scanner(System.in);

    public HumanPlayer() {
        System.out.print("Enter your name: ");
        this.name = SCANNER.nextLine();
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
    public void move(Board board) {
        System.out.print(getName() + ", enter coordinates (line [x], column [y]) space separator between coordinates: ");
        int row = SCANNER.nextInt() - 1;
        int col = SCANNER.nextInt() - 1;
        board.makeMove(row,col,this);
    }
}
