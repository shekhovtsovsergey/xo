package ru.shekhovtsov.xo.game;

import ru.shekhovtsov.xo.players.ComputerPlayer;
import ru.shekhovtsov.xo.players.HumanPlayer;
import ru.shekhovtsov.xo.players.Player;

import java.util.Scanner;

public class Game {

    private int currentPlayerIndex;
    private boolean gameOver;
    private Player[] players;

    public boolean getGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public Game() {
        this.currentPlayerIndex=0;
        this.gameOver=false;
        this.players = new Player[2];
    }

    public void play() {
        Board board = new Board(this);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose working mode: ");
        System.out.println("1. Human Player vs. Human Player");
        System.out.println("2. Human Player vs. Computer Player");
        System.out.println("3. Computer Player vs. Computer Player");
        String opponentChoice = scanner.next();

        if (opponentChoice.equals("1")) {
            players[0] = new HumanPlayer();
            players[1] = new HumanPlayer();
        } else if (opponentChoice.equals("2")) {
            players[0] = new HumanPlayer();
            players[1] = new ComputerPlayer((players[0].getSymbol() == 'X') ? 'O' : 'X');
        } else {
            players[0] = new ComputerPlayer('X');
            players[1] = new ComputerPlayer('O');
        }

        while (!gameOver) {
            players[currentPlayerIndex].move(board);
            currentPlayerIndex = (currentPlayerIndex + 1) % players.length;
            board.print();
        }
    }

}
