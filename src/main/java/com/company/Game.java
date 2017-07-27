package com.company;

import java.io.IOException;

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
        while (!gameBoard.isSolved()){
            try {
                inputKey = System.in.read();
                switch (inputKey){
                    case 119: // w
                        gameBoard.moveTile(Direction.UP);
                        view.drawBoard(gameBoard.getTiles());

                        break;
                    case  97: // a
                        gameBoard.moveTile(Direction.LEFT);
                        view.drawBoard(gameBoard.getTiles());

                        break;
                    case  100: // d
                        gameBoard.moveTile(Direction.RIGHT);
                        view.drawBoard(gameBoard.getTiles());

                        break;
                    case  115: // s
                        gameBoard.moveTile(Direction.DOWN);
                        view.drawBoard(gameBoard.getTiles());

                        break;
                    case 116: // t
                        System.out.println("See you soon!");
                        System.exit(0);
                    default: break;
                }
            } catch (IOException e) {
                System.out.println("Exception during reading key: " + e);
            }
        }
        System.out.println("You win!");
    }
    
}
