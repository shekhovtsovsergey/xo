package ru.shekhovtsov.xo.game;

import ru.shekhovtsov.xo.players.ComputerPlayer;
import ru.shekhovtsov.xo.players.HumanPlayer;
import ru.shekhovtsov.xo.players.Player;

public class Game {

    int currentPlayerIndex = 0;

    public void play() {
        Board board = new Board();
        Player[] players = new Player[2];
        players[0] = new HumanPlayer();
        players[1] = new ComputerPlayer();

        while (!board.isGameOver()) {
            players[currentPlayerIndex].move(board);
            currentPlayerIndex = (currentPlayerIndex + 1) % players.length;
            board.print();
        }
    }
}
