package ru.shekhovtsov.xo;

import java.util.Scanner;

public class HumanPlayer {

    private Scanner scanner;
    private char fishka;
    private Game game;

    public HumanPlayer( Game game, char fishka) {
        this.game = game;
        this.scanner = new Scanner(System.in);
        this.fishka = fishka;
    }


    public void makeTurn (){

        while (true){
            System.out.println("Ход игрока: введите строку, столбец");
            int y = scanner.nextInt();
            int x = scanner.nextInt();
            if (game.getBoard().setData(x, y, fishka)){
                break;
            }
        }

    }


}
