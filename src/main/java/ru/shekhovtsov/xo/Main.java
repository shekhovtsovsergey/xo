package ru.shekhovtsov.xo;

import ru.shekhovtsov.xo.game.Game;
import ru.shekhovtsov.xo.game.GameImpl;

public class Main {

    public static void main(String[] args) {
        Game game = new GameImpl();
        game.play();
    }
}



//вшить игрока в игру
//Добавить ИИ который выбирает случайные координаты и ставит фишку
//добавить игровой цикл в котором будет ходить первый и второй игрок
//добавить проверку того что поле заполнилось - останавливаемигру
//добавить проверку победы
//обьединить игроков под интерфейс выбирать кто первый кто второй*
