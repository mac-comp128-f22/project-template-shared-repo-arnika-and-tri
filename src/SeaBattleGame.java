import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Image;
import edu.macalester.graphics.ui.TextField;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class SeaBattleGame {
    private static final int CANVAS_WIDTH = 396;
    private static final int CANVAS_HEIGHT = 828;
    private static final int cellSize = 36;
    private static final int numRows = 21;
    private static final int numCols = 10;
    private Grid grid;
    private CanvasWindow canvas;
    private HomeScreen screens;
    private String[][] maze;
    private TextField coordinateField1;
    private TextField coordinateField2;


    public SeaBattleGame() {
        canvas = new CanvasWindow("Sea Battle", CANVAS_WIDTH, CANVAS_HEIGHT);
        canvas.setBackground(Color.GRAY);
        screens = new HomeScreen(canvas, this);
        screens.homeScreen();
    }

    public void playingScreen() {
        settingUpGame();
        getCoordinates();
        addCoordinateLabels();
    }

    private void getCoordinates() {
        coordinateField1 = new TextField();
        coordinateField1.setCenter(CANVAS_WIDTH + 50, CANVAS_HEIGHT / 2 - 2 * coordinateField1.getHeight());
        canvas.add(coordinateField1);

        coordinateField2 = new TextField();
        coordinateField2.setCenter(CANVAS_WIDTH + 50, CANVAS_HEIGHT / 2 - 20);
        canvas.add(coordinateField2);

        CustomButton coordinatesButton = new CustomButton("Enter coordinate: ");
        coordinatesButton.setCenter(CANVAS_WIDTH + 20 + coordinatesButton.getWidth() / 2,
            CANVAS_HEIGHT / 2 + 7);
        canvas.add(coordinatesButton);

        Image coordinateImage = new Image("sprite-icons/coordinate-button.png");
        coordinateImage.setCenter(CANVAS_WIDTH + 20 + coordinatesButton.getWidth() / 2,
            CANVAS_HEIGHT / 2 + 7);
        coordinateImage.setScale(0.22);
        canvas.add(coordinateImage);


        coordinatesButton.onClick(() -> shootMissile());

    }

    private void shootMissile() {
        int row = Integer.parseInt(coordinateField1.getText());
        int col = Integer.parseInt(coordinateField2.getText());
        System.out.println("Num row: " + row);
        System.out.println("Num col: " + col);

        maze[row][col] = "Shooted";
        int compRow = 11 + (int) (Math.random() * 10);
        int compCol = (int) (Math.random() * 10);
        System.out.println(compRow + ", " + compCol);
        maze[compCol][compRow] = "Shooted";
        System.out.println(Arrays.deepToString(maze).replace("], ", "]\n").replace("[[", "[").replace("]]", "]"));
        Grid grid = new Grid(numCols, numRows, cellSize, maze, this);

        canvas.add(grid);
        System.out.println(checkWin());
        if (checkWin() == 1 || checkWin() == -1) {
            if(checkWin() == 1){
                System.out.println("Player Win!");
            } else{ 
                System.out.println("Computer Win!");
            }
            canvas.closeWindow();
            ;
        }

        // Cell cell = new Cell(cellSize);
        // cell.getGraphics().setPosition(row * cellSize, col * cellSize);
        // cell.addGraphics(new Shooted(cellSize, cellSize));


    }

    private int checkWin() {
        boolean playerHasShip = false;
        boolean compHasShip = false;
        for (int i = 0; i < numCols; i++) {
            for (int j = 0; j < 10; j++) {
                if (maze[i][j] == "S") {
                    playerHasShip = true;
                }
            }
        }

        for (int i = 0; i < numCols; i++) {
            for (int j = 11; j < 21; j++) {
                if (maze[i][j] == "S") {
                    compHasShip = true;
                }
            }
        }
        int res = 0;
        if (!playerHasShip) {
            res = 1;
        } else if (!compHasShip) {
            res = -1;
        }
        return res;
    }

    private void addCoordinateLabels() {
        Image rowNums = new Image("sprite-icons/row-nums.png");
        rowNums.setCenter(CANVAS_WIDTH - 17, CANVAS_HEIGHT / 2 - 20);
        rowNums.setScale(0.4);
        canvas.add(rowNums);

        Image columnLetter = new Image("sprite-icons/column-letters.png");
        columnLetter.setCenter(CANVAS_WIDTH / 2 - 20, CANVAS_HEIGHT - columnLetter.getHeight() / 2 - 28);
        columnLetter.setScale(0.4);
        canvas.add(columnLetter);
    }

    private void settingUpGame() {
        generateGrid();
        canvas.draw();
        grid = new Grid(10, 21, cellSize, maze, this);
        canvas.add(grid);
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
