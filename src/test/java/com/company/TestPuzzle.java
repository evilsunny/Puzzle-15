package com.company;


import org.junit.Assert;
import org.junit.Test;
public class TestPuzzle {
    private int boardSize = 4;

    @Test
    public void testIsSolvable(){
        int[][] tiles = new int[boardSize][boardSize];
        for (int i = 0; i < boardSize * boardSize - 1 ; i++)
            tiles[i / boardSize][i % boardSize] = i + 1;
        tiles[3][1] = 15;
        tiles[3][2] = 14;
        Board b = new Board();
        b.setTiles(tiles);
        Assert.assertFalse(b.isSolvable());
    }

    @Test
    public void testMoveTile(){
        int[][] tiles = new int[boardSize][boardSize];
        for (int i = 0; i < boardSize * boardSize - 1; i++)
            tiles[i / boardSize][i % boardSize] = i + 1;

        Board b = new Board();
        b.setTiles(tiles);

        int[][] resultTiles = new int[boardSize][boardSize];
        for (int i = 0; i < boardSize * boardSize - 1; i++)
            resultTiles[i / boardSize][i % boardSize] = i + 1;
        resultTiles[3][2] = 0;
        resultTiles[3][3] = 15;

        b.moveTile(Direction.RIGHT);
        Assert.assertArrayEquals(b.getTiles(), resultTiles);

        b.moveTile(Direction.UP);
        Assert.assertArrayEquals(b.getTiles(), resultTiles);

    }

    @Test
    public void testIsInitSolvable(){
        Board b = new Board();
        Assert.assertTrue(b.isSolvable());
    }

    @Test
    public void testIsSolved(){
        int[][] tiles = new int[boardSize][boardSize];
        for (int i = 1; i < boardSize * boardSize; i++)
            tiles[i / boardSize][i % boardSize] = i;
        Board b = new Board();
        b.setTiles(tiles);
        Assert.assertTrue(b.isSolved());
    }

}
