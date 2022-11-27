import edu.macalester.graphics.CanvasWindow;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

public class SeaBattleGame {
    private static final int CANVAS_WIDTH = 400;
    private static final int CANVAS_HEIGHT = 840;
    private static final int cellSize = 40;
    private Grid grid;
    private CanvasWindow canvas;
    private HomeScreen screens;
    private String[][] maze;


    public SeaBattleGame() {
        canvas = new CanvasWindow("Sea Battle", CANVAS_WIDTH, CANVAS_HEIGHT);
        canvas.setBackground(Color.WHITE);
        screens = new HomeScreen(canvas, this);
        screens.homeScreen();

    }

    public void playingScreen() {
        settingUpGame();
        grid = new Grid(10, 21, cellSize, maze, this);
        canvas.add(grid);
        canvas.onMouseDown(event-> {
            if(event.getClass().toString().equals("Rectangle")){
                event.get
            }
        });
    }

    private void settingUpGame() {
        generateGrid();
        canvas.draw();
    }

    private void generateGrid() {
        int size = 10;
        Random random = new Random();
        int[][] playerBoard = new int[size][size];
        int[][] opponentBoard = new int[size][size];
        ArrayList<int[][]> playerBoards = new ArrayList<int[][]>(2);
        playerBoards.add(playerBoard);
        playerBoards.add(opponentBoard);

        for (int[][] board : playerBoards) {
            for (int i = 5; i > 0; i--) {
                // start point of the ship and direction
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
                // check for free space
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
                if (!isFree) {  // no free space found, retry
                    i++;
                    continue;
                }

                // fill in the adjacent cells
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
                for (int j = 0; j < i; j++) {
                    board[y][x] = i;
                    if (vertical) {
                        y++;
                    } else {
                        x++;
                    }
                }
            }
        }
        maze = new String[10][21];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 21; j++) {
                if (j < 10) {
                    if (playerBoard[i][j] == 0 || playerBoard[i][j] == 9) {
                        maze[i][j] = "R";
                    } else {
                        maze[i][j] = "S";
                    }
                } else if (j == 10) {
                    maze[i][j] = "W";
                } else {
                    if (opponentBoard[i][j - 11] == 0 || opponentBoard[i][j - 11] == 9) {
                        maze[i][j] = "R";
                    } else {
                        maze[i][j] = "S";
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        new SeaBattleGame();
    }
}
