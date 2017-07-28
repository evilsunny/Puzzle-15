package com.company;

import java.io.IOException;
import java.util.Scanner;

/**
 * Represents 15-puzzles game, contains board and drawer which can
 * display the course of the game. Reacts to player's actions and
 * change state of board.
 */
public class Game {
    private Board gameBoard;
    private GameView view;

    public Game(Board board, GameView view){
        this.gameBoard = board;
        this.view = view;
    }

    public void start() {
        view.drawBoard(gameBoard.getTiles());
        int inputKey = 0;
        Scanner s = new Scanner(System.in);
        String input;
        while (!gameBoard.isSolved()){
                input = s.nextLine();

                switch (input){
                    case "s":
                        gameBoard.moveTile(Direction.UP);
                        view.drawBoard(gameBoard.getTiles());
                        break;
                    case  "d":
                        gameBoard.moveTile(Direction.LEFT);
                        view.drawBoard(gameBoard.getTiles());
                        break;
                    case  "a":
                        gameBoard.moveTile(Direction.RIGHT);
                        view.drawBoard(gameBoard.getTiles());

                        break;
                    case  "w":
                        gameBoard.moveTile(Direction.DOWN);
                        view.drawBoard(gameBoard.getTiles());
                        break;
                    case "new":
                        gameBoard.initRandomTiles();
                        view.drawBoard(gameBoard.getTiles());
                        break;
                    case "exit":
                        System.out.println("See you soon!");
                        System.exit(0);
                    default: break;
                }

        }
        System.out.println("You win!");
    }

}
