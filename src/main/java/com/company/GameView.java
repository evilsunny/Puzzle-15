package com.company;

/**
 * Displays game board in terminal
 */
class GameView {
      void drawBoard (int[][] tiles){
        System.out.println("_________________________");

         for (int[] tile : tiles) {
             System.out.print("| ");
             for (int j = 0; j < tiles.length; j++) {

                 if (tile[j] != 0)
                    System.out.printf("%3d", tile[j]);
                 else
                     System.out.printf("%3s", " ");
                 System.out.print(" | ");
             }
             System.out.println("\n_________________________");
         }
        System.out.println("\n\n\n");
    }
}
