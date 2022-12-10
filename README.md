# Sea Battle!

*By Arnika Abeysekera, Tri Bui*

## Project Overview

Sea Battle Game is a two-person strategy type guessing game. It is played on ruled grids in which each player's fleet of warships are marked. The locations of the fleets are randomly generated for each player and are concealed from the opponent. 

The objective of the game is to try and find all of their ships and “sink” them through the bombing, or clicking on the correct location of the ships. The players go back and forth choosing a square on the grid to click, trying to find a ship. Once a player has sunk all of their opponents ships, the game is won. 

## How to Run

To run and play the game:
1. Enter the `SeaBattleGame` class.
2. Run the `SeaBattleGame` class by either scrolling to the bottom of the class and running the main method, or clicking the run button in the top right hand corner of the screen.

## How to Play

To play the game, run the code and click the play button. Enter the coordinates of the square you want to check for a ship in the textfields at the bottom of the screen (entering the x/column value in the first textfield, and the y/row value in the second). The square you have chosen to "bomb" will turn green if you have correctly found a ship, and red if you haven't and have instead hit the river. Use this color system to check how many ships you have found. There are five ships in total (for each player) of lengths 5, 4, 3, 2, and 1, respectively. Continue entering coordinates until one of the player have found all of their opponent's ships. 

## Disclaimer

If images are not showing up, or you see a red X bounded be a box on the screen, that may mean that you need to download the images to your laptop and then reload the game, to be able to view the images. If needed, the images can be found and downloaded from [this drive](https://drive.google.com/drive/folders/1xXfyN0QN7NGnEiZ5fl7XgGy-2yQac1Iv).

## How To Test

To test the program, you could try the followings:
1. Test the youWin and youLose functions.
QuickTest: You can enter a fixed coordinate and press shoot continuously to a fixed location in the opponent board to quickly check if it works on the player board (the above one).
2. Test to see if it generates a boat in a random new position every time we replay. You can run and rerun the program many times to check.
3. Test to see if the 2D array and Map are working correctly. We have a ready print function for both the 2D display and the Map. You can uncomment to check. Every time you shoot, you can test the operation and logic behind them (the maze and shootCoordinate)
4. Check if the shoot is correct with the number you entered. You can directly check it quickly by entering a random coordinate, then check a newly shooted square coordinate using the 2 numerical labels for the row and column of the opponent's board.


## Acknowledgements

This game is based entirely off of Battleship by Ed Hutchins. 

Code
- Starting code for the `createGrid()` method in the `Grid` class by Benjamin Hillmann. 
- Original code for the `CustomButton` and `EmbeddedSwingComponent` classes copied (and modified) from the Macalester kilt-graphics. 

Graphics
- Graphic text made using [this website](https://fontmeme.com/). 
