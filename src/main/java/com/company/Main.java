package com.company;

public class Main {

    public static void main(String[] args) {
        GameView view = new GameView();
        Board board = new Board();
        Game game = new Game(board, view);
        game.start();
    }
}
