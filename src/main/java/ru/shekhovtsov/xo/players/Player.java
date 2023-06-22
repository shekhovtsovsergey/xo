package ru.shekhovtsov.xo.players;

import ru.shekhovtsov.xo.game.Board;

public interface Player {

    char getSymbol();

    String getName();
    void move(Board board);
}
