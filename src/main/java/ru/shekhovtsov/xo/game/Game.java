package ru.shekhovtsov.xo.game;

import ru.shekhovtsov.xo.players.ComputerPlayer;
import ru.shekhovtsov.xo.players.HumanPlayer;
import ru.shekhovtsov.xo.players.Player;

import java.util.Random;
import java.util.Scanner;

public class Game {

    private final int SIZE = 3;
    private final char CROSS = 'X';
    private final char ZERO = 'O';
    private final Random RANDOM = new Random();
    private final Scanner SCANNER = new Scanner(System.in);
    private int countEmpty = SIZE * SIZE;
    private Player player1;
    private Player player2;


    //количество оставшихся клеток перенести на поле когда фишка ставится на поле поле само решает результат (отвечает есть ли свободные клетки или нет)
    //переписать в 1 такт цикла ходит первый игрок потом второй игрок
    //правило хождения как игроки ходят должно жить в классах игроков
    //поля раскидать чтобы поля принадлежали своим классам
    //инстанс оф убрать :)


    public void play() {
        initField();
        initPlayers();
        boolean isPlayer1Move = false;


        while (true) {
            printGrid();

            Player currentPlayer;
            if (isPlayer1Move) {
                currentPlayer = player1;
            } else {
                currentPlayer = player2;
            }
            makeMove(currentPlayer);
            if (isWin(currentPlayer)) {
                printGrid();
                System.out.println(currentPlayer.getName() + " Победил!");
                break;
            }
            if (--countEmpty == 0) {
                printGrid();
                System.out.println("Ничья!");
                break;
            }
            isPlayer1Move = !isPlayer1Move;
        }
    }

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




}
