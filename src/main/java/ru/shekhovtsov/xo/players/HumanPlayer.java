package ru.shekhovtsov.xo.players;

import ru.shekhovtsov.xo.game.Board;

import java.util.Scanner;

public class HumanPlayer implements Player {

    private final String name;
    private char symbol;
    private final Scanner SCANNER = new Scanner(System.in);

    public HumanPlayer() {
        System.out.print("Enter your name: ");
        this.name = SCANNER.nextLine();
        while (true) {
            System.out.print("Choose X or 0 as your symbol: ");
            char chosenSymbol = SCANNER.nextLine().charAt(0);
            if (chosenSymbol == 'X' || chosenSymbol == '0') {
                this.symbol = chosenSymbol;
                break;
            } else {
                System.out.println("Invalid symbol, try again.");
            }
        }
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
        while (true) {
            System.out.print(getName() + ", enter coordinates (line [x], column [y]) space separator between coordinates: ");
            int row = SCANNER.nextInt() - 1;
            int col = SCANNER.nextInt() - 1;
            if (board.makeMove(row, col, this)) {
                break;
            } else {
                System.out.println("Invalid move, try again.");
            }
        }
    }
}
