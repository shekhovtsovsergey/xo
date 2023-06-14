package ru.shekhovtsov.xo.game;

import ru.shekhovtsov.xo.players.ComputerPlayer;
import ru.shekhovtsov.xo.players.HumanPlayer;
import ru.shekhovtsov.xo.players.Player;

public interface Game {
    void play();
    void initField();
    void initPlayers();
    void printField();
    void makeMove(Player player);
    void makeHumanMove(HumanPlayer player);
    void makeComputerMove(ComputerPlayer player);
    boolean isWin(Player player);
}
