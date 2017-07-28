package com.company;


import com.google.common.annotations.VisibleForTesting;

/**
 * Represents board 4x4 for 15-puzzle game with 15 tiles which can be moved
 */
public class Board {

    private final int size = 4;
    private int[][] tiles;
    private int emptyCol = size - 1;
    private int emptyRow = size - 1;

    /**
     * Initializes board with random (but solvable) set of tiles.
     */
    public Board(){
        initRandomTiles();
    }

    public void initRandomTiles(){
        tiles = new int[size][size];

        for (int i = 1; i < size * size; i++){
            int curIndex = (int) (Math.random() * (size * size - 1));
            while (tiles[curIndex / size][curIndex % size] != 0){
                curIndex = (int) (Math.random() * (size * size - 1));
            }
            tiles[curIndex / size][curIndex % size] = i;
        }
        if (!isSolvable())
            makeSolvable();
    }

    @VisibleForTesting
     boolean isSolvable(){
        int chaos = 0;
        int curTileValue;
        for(int i = 0; i < size * size - 2; i++){
            curTileValue = tiles[i / size][i % size];
            for(int j = i + 1; j < size * size - 1; j++){
                if(curTileValue > tiles[j / size][j % size])
                    chaos++;
            }
        }
        return chaos % 2 != 1;
    }

    private void makeSolvable(){
            int tempTile = tiles[size - 1][size -2];
            tiles[size - 1][size - 2] = tiles[size - 1][size - 3];
            tiles[size - 1][size - 3] = tempTile;
    }

    /**
     * In 15-puzzle at every direction can be moved maximum 1 tile.
     * Moves the one tile which can be moved, if there is no tile which can be moved
     * in specified direction, does nothing
     * @param d direction to move tile
     */
    public void moveTile(Direction d){
        switch (d){
            case LEFT:
                if (emptyRow < size - 1){
                    int tmpTile = tiles[emptyCol][emptyRow + 1];
                    tiles[emptyCol][emptyRow + 1] = 0;
                    tiles[emptyCol][emptyRow] = tmpTile;
                    emptyRow ++;
                }
                break;

            case DOWN:
                if (emptyCol > 0){
                    int tmpTile = tiles[emptyCol - 1][emptyRow];
                    tiles[emptyCol - 1][emptyRow] = 0;
                    tiles[emptyCol][emptyRow] = tmpTile;
                    emptyCol --;
                }
                break;

            case RIGHT:
                if (emptyRow > 0){
                    int tmpTile = tiles[emptyCol][emptyRow - 1];
                    tiles[emptyCol][emptyRow - 1] = 0;
                    tiles[emptyCol][emptyRow] = tmpTile;
                    emptyRow --;
                }
                break;

            case UP:
                if (emptyCol < size - 1){
                    int tmpTile = tiles[emptyCol + 1][emptyRow];
                    tiles[emptyCol + 1][emptyRow] = 0;
                    tiles[emptyCol][emptyRow] = tmpTile;
                    emptyCol ++;
                }

        }
    }

    public boolean isSolved(){
        for (int i = 1; i < size * size; i++){
            if (tiles[i / size][i % size] != i)
                return false;
        }
        return true;
    }

    public int[][] getTiles(){
        return tiles;
    }

    @VisibleForTesting
    void setTiles(int[][] tiles){
        this.tiles = tiles;
    }
}
