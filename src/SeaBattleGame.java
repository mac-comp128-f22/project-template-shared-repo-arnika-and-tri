import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Point;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * The main class of the game of SeaBattle that handles the logic and running of the game.
 */
public class SeaBattleGame {
    private static final int cellSize = 36;
    private static final int numRows = 21;
    private static final int numCols = 10;

    private Grid grid;
    private CanvasWindow canvas;
    private GameGUI screens;
    private String[][] populatedGrid;
    private int[][] playerBoard;
    private int[][] opponentBoard;
    private Map<String, Map<String, ArrayList<Point>>> shipCoordinates;
    private Map<Point, Boolean> shotCoordinates;


    /**
     * Initializes a game of SeaBattle, displaying its main screen.
     */
    public SeaBattleGame() {
        canvas = new CanvasWindow("Sea Battle", GameGUI.CANVAS_WIDTH, GameGUI.CANVAS_HEIGHT);
        canvas.setBackground(Color.GRAY);
        screens = new GameGUI(canvas, this);
        screens.homeScreen();
        shotCoordinates = new HashMap<>();
        shipCoordinates = new HashMap<>();
    }

    /***
     * Randomly generates the location of the ships in the grid.
     */
    private void generateShipLocations() {
        int size = 10;
        Random random = new Random();
        playerBoard = new int[size][size];
        opponentBoard = new int[size][size];
        ArrayList<int[][]> gameBoards = new ArrayList<int[][]>(2);
        gameBoards.add(playerBoard);
        gameBoards.add(opponentBoard);

        for (int[][] board : gameBoards) {
            Map<String, ArrayList<Point>> boardShips = new HashMap<>();
            for (int i = 5; i > 0; i--) {
                // get random start point and direction of the ship
                int x = random.nextInt(board.length);
                int y = random.nextInt(board.length);
                boolean vertical = random.nextBoolean();

                // correct start point so that the ship could fit in the field
                if (vertical) {
                    if (y + i > size) {
                        y -= i;
                    }
                } else if (x + i > size) {
                    x -= i;
                }
                boolean isFree = true;

                // check if there is free space for the entire ship
                if (vertical) {
                    for (int m = y; m < y + i; m++) {
                        if (board[m][x] != 0) {
                            isFree = false;
                            break;
                        }
                    }
                } else {
                    for (int n = x; n < x + i; n++) {
                        if (board[y][n] != 0) {
                            isFree = false;
                            break;
                        }
                    }
                }
                // if no free space found, retry
                if (!isFree) {
                    i++;
                    continue;
                }

                // fill in the adjacent cells, so that no other ship can populate them
                if (vertical) {
                    for (int m = Math.max(0, x - 1); m < Math.min(size, x + 2); m++) {
                        for (int n = Math.max(0, y - 1); n < Math.min(size, y + i + 1); n++) {
                            board[n][m] = 9;
                        }
                    }
                } else {
                    for (int m = Math.max(0, y - 1); m < Math.min(size, y + 2); m++) {
                        for (int n = Math.max(0, x - 1); n < Math.min(size, x + i + 1); n++) {
                            board[m][n] = 9;
                        }
                    }
                }
                // fill in the ship cells
                ArrayList<Point> singleShipCoordinates = new ArrayList<>(i - 1);
                for (int j = 0; j < i; j++) {
                    board[y][x] = i;
                    if (board.equals(playerBoard)) {
                        singleShipCoordinates.add(new Point(y, x + 11));
                    } else {
                        singleShipCoordinates.add(new Point(y, x));
                    }
                    if (vertical) {
                        y++;
                    } else {
                        x++;
                    }
                }
                boardShips.put("Ship Length:" + i, singleShipCoordinates);
            }
            if (board.equals(playerBoard)) {
                shipCoordinates.put("Opponent Ships", boardShips);
            } else {
                shipCoordinates.put("Player Ships", boardShips);
            }
        }
    }

    /***
     * A single turn of the game, including both the player and computer movements and checking if the
     * game is finished or not.
     */
    public void shootMissile() {
        playerTurn();
        if (youWin()) {
            screens.winMessage();
        }
        computerTurn();
        if (youLose()) {
            screens.loseMessage();
        }
    }

    /***
     * The player's shooting turn takes in user input to hit the computer's ships.
     */
    private void playerTurn() {
        int col = Integer.parseInt(screens.coordinateField1.getText());
        int row = Integer.parseInt(screens.coordinateField2.getText());
        shotCoordinates.put(new Point(col, row + 11), true);
        if (populatedGrid[col][row + 11].equals("S") || populatedGrid[col][row + 11].equals("C")) {
            canvas.add(grid.setCellGraphics(col, row + 11, "C"));
            populatedGrid[col][row + 11] = "C";
        } else {
            canvas.add(grid.setCellGraphics(col, row + 11, "W"));
            populatedGrid[col][row + 11] = "W";
        }
    }

    /***
     * Computer shooting turn, which generate a random coordinates to shoot on the player board.
     */
    private void computerTurn() {
        int row = (int) (Math.random() * 10);
        int col = (int) (Math.random() * 10);
        Point coordinates = new Point(col, row);
        while (shotCoordinates.get(coordinates)) {
            row = (int) (Math.random() * 10);
            col = (int) (Math.random() * 10);
            coordinates = new Point(col, row);
        }
        if (populatedGrid[col][row].equals("S") || populatedGrid[col][row].equals("C")) {
            canvas.add(grid.setCellGraphics(col, row, "C"));
            populatedGrid[col][row] = "C";
        } else {
            canvas.add(grid.setCellGraphics(col, row, "W"));
            populatedGrid[col][row] = "W";
        }
        shotCoordinates.put(new Point(col, row), true);
    }

    /***
     * Checks if the player has won by checking if all of the opponent's ships have been hit.
     */
    private boolean youWin() {
        for (int i = 1; i < shipCoordinates.get("Opponent Ships").size() + 1; i++) {
            for (Point point : shipCoordinates.get("Opponent Ships").get("Ship Length:" + i)) {
                if (!shotCoordinates.get(point)) {
                    return false;
                } else {
                    continue;
                }
            }
        }
        return true;
    }

    /***
     * Checks if the player has lost by checking if all of their ships have been hit.
     */
    private boolean youLose() {
        for (int i = 1; i < shipCoordinates.get("Player Ships").size() + 1; i++) {
            for (Point point : shipCoordinates.get("Player Ships").get("Ship Length:" + i)) {
                if (!shotCoordinates.get(point)) {
                    return false;
                } else {
                    continue;
                }
            }
        }
        return true;
    }

    /***
     * Fills in the grid cells (in the game grid) according to the previously determined random
     * locations of the ships.
     */
    private void populateGrid() {
        generateShipLocations();
        populatedGrid = new String[numCols][numRows];
        for (int i = 0; i < numCols; i++) {
            for (int j = 0; j < numRows; j++) {
                if (j < 10) {
                    if (opponentBoard[i][j] == 0 || opponentBoard[i][j] == 9) {
                        populatedGrid[i][j] = "R";
                    } else {
                        populatedGrid[i][j] = "S";
                    }
                } else if (j == 10) {
                    populatedGrid[i][j] = "W";
                } else {
                    if (playerBoard[i][j - 11] == 0 || playerBoard[i][j - 11] == 9) {
                        populatedGrid[i][j] = "R";
                    } else {
                        populatedGrid[i][j] = "S";
                    }
                }
                shotCoordinates.put(new Point(i, j), false);
            }
        }
    }

    /***
     * Creates the grid using the random locations of the ships and adds it to the canvas.
     */
    public void generateGrid() {
        populateGrid();
        canvas.draw();
        grid = new Grid(numCols, numRows, cellSize, populatedGrid);
        canvas.add(grid);
    }

    /**
     * Click here to run the game.
     */
    public static void main(String[] args) {
        new SeaBattleGame();
    }
}
