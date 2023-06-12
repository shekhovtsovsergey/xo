package ru.shekhovtsov.xo;

public class Game {

    private Board board;

    public Board getBoard() {
        return board;
    }

    public Game() {
        this.board = new Board(3);
    }

    public void run(){
        System.out.println("Игра началась");
        board.print();
    }

}
