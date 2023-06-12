package ru.shekhovtsov.xo;


public class Board {

    private int size;
    private char[][] data; // [y][x]
    private final char EMPTY_CELL = '*';


    public Board(int size) {
        this.size = size;
        this.data = new char[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                data[i][j] = EMPTY_CELL;
            }
        }
    }


    public void print() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(data[i][j] + " ");
            }
            System.out.println();
        }
    }


    public boolean setData(int x, int y,char fishka) {
        if (y<0 || y >= size || x <0 || x >= size) {
            return false;
        }
        if (data[y][x] != EMPTY_CELL){
            return false;
        }
        data[y][x] = fishka;
        return true;
    }

}
