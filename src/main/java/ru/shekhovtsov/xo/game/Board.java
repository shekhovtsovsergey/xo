package ru.shekhovtsov.xo.game;


import ru.shekhovtsov.xo.players.Player;

public class Board {

    private final int SIZE = 3;
    private final char EMPTY = ' ';
    private char[][] field = new char[SIZE][SIZE];
    private int countEmpty = SIZE * SIZE;
    private boolean  gameOver = false;


    public Board() {
        initField();
        print();
    }

    public void makeMove(int row, int column, Player player) {
        if (field[row][column] == EMPTY) {
            placeSymbol(row, column, player.getSymbol());
            if (isWin(player)) {
                System.out.println("Player " + player.getName() + " win!");
                setGameOver(true);
            } else if (!hasEmptyCells()) {
                System.out.println("Draw!");
                setGameOver(true);
            }
        } else {
            System.out.println("Cell is occupied!");
            player.move(this);
        }
    }

    public void initField() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                field[i][j] = EMPTY;
            }
        }
    }

    public void print() {
        System.out.println("    1   2   3 ");
        System.out.println("----------------");
        for (int i = 0; i < 3; i++) {
            System.out.print((i + 1) + " | ");
            for (int j = 0; j < 3; j++) {
                System.out.print(field[i][j] + " | ");
            }
            System.out.println();
            System.out.println("---------------");
        }
    }

    public boolean isWin(Player player) {
        char symbol = player.getSymbol();
        for (int i = 0; i < SIZE; i++) {
            if (field[i][0] == symbol && field[i][1] == symbol && field[i][2] == symbol) {
                return true;
            }
            if (field[0][i] == symbol && field[1][i] == symbol && field[2][i] == symbol) {
                return true;
            }
        }
        if (field[0][0] == symbol && field[1][1] == symbol && field[2][2] == symbol) {
            return true;
        }
        if (field[0][2] == symbol && field[1][1] == symbol && field[2][0] == symbol) {
            return true;
        }
        return false;
    }

    public void placeSymbol(int row, int column, char symbol) {
        field[row][column] = symbol;
        countEmpty--;
    }

    public boolean hasEmptyCells() {
        return countEmpty > 0;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

}
