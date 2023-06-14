package ru.shekhovtsov.xo.game;

import ru.shekhovtsov.xo.players.ComputerPlayer;
import ru.shekhovtsov.xo.players.HumanPlayer;
import ru.shekhovtsov.xo.players.Player;

import java.util.Random;
import java.util.Scanner;

public class GameImpl implements Game{

    private final int SIZE = 3;
    private final char EMPTY = ' ';
    private final char CROSS = 'X';
    private final char ZERO = 'O';
    private final Random RANDOM = new Random();
    private final Scanner SCANNER = new Scanner(System.in);
    private char[][] field = new char[SIZE][SIZE];
    private int countEmpty = SIZE * SIZE;
    private Player player1;
    private Player player2;


    @Override
    public void play() {
        initField();
        initPlayers();
        boolean isPlayer1Move = false;

        while (true) {
            printField();
            Player currentPlayer;
            if (isPlayer1Move) {
                currentPlayer = player1;
            } else {
                currentPlayer = player2;
            }
            makeMove(currentPlayer);
            if (isWin(currentPlayer)) {
                printField();
                System.out.println(currentPlayer.getName() + " Победил!");
                break;
            }
            if (--countEmpty == 0) {
                printField();
                System.out.println("Ничья!");
                break;
            }
            isPlayer1Move = !isPlayer1Move;
        }
    }



    @Override
    public void initField() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                field[i][j] = EMPTY;
            }
        }
    }

    @Override
    public void initPlayers() {
        System.out.print("Введите свое имя: ");
        String name = SCANNER.nextLine();
        player1 = new HumanPlayer(name, CROSS);
        player2 = new ComputerPlayer(ZERO);
        if (RANDOM.nextBoolean()) {
            Player temp = player1;
            player1 = player2;
            player2 = temp;
        }
    }

    @Override
    public void printField() {
        System.out.println();
        System.out.print("  ");
        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + 1 + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(field[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    @Override
    public void makeMove(Player player) {
        if (player instanceof HumanPlayer) {
            makeHumanMove((HumanPlayer) player);
        } else {
            makeComputerMove((ComputerPlayer) player);
        }
    }

    @Override
    public void makeHumanMove(HumanPlayer player) {
        while (true) {
            System.out.print(player.getName() + ", введите координаты (строка, колонка) разделитель пробел между координатами: ");
            int row = SCANNER.nextInt() - 1;
            int col = SCANNER.nextInt() - 1;
            if (row >= 0 && row < SIZE && col >= 0 && col < SIZE && field[row][col] == EMPTY) {
                field[row][col] = player.getSymbol();
                break;
            } else {
                System.out.println("Ошибка еще раз");
            }
        }
    }

    @Override
    public void makeComputerMove(ComputerPlayer player) {
        while (true) {
            int row = RANDOM.nextInt(SIZE);
            int col = RANDOM.nextInt(SIZE);
            if (field[row][col] == EMPTY) {
                field[row][col] = player.getSymbol();
                break;
            }
        }
        System.out.println("Ходит компьютер: ");
    }



    @Override
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
}
