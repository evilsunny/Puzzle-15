<a name="sec-about"> </a>
About 15-Puzzle
==============


    Game is represented by 4x4 tiles board where 15 numbered tiles are initially placed
in random order and where 16th tile is missing. A tile can be moved to a
neighbour empty place.
    To succeed in the game you need to order tiles from 1 to 15, where tile
number 1 is at the top left corner and empty one is at the bottom right corner.

 For moving empty tile use keys:
 + w - ↑  
 + d - →  
 + s - ↓  
 + a - ←  

Press Enter for confirmation your move.

For creating new board type 'new' and Enter  


For exiting from game type 'exit' end Enter.

If you want to try to play make

+ mvn clean install
+ mvn exec:java -Dexec.mainClass="com.company.Main"
