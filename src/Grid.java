import edu.macalester.graphics.GraphicsGroup;

import java.util.List;

/**
 * Represents a grid of cells that is populated to form the maze and all its elements (coins,
 * ghosts, walls and player).
 */
public class Grid extends GraphicsGroup {
    protected int numRows, numCols;
    protected double size;
    private SeaBattleGame game;
    protected Cell[][] cells;
    private int playerRow = 11;
    private int playerCol = 11;

    private static final int DIRECTION_UP = 0;
    private static final int DIRECTION_DOWN = 1;
    private static final int DIRECTION_LEFT = 2;
    private static final int DIRECTION_RIGHT = 3;

    /**
     * Initializes a grid with a speicified number of rows and columns and overall size.
     */
    public Grid(int numRows, int numCols, int size, String[][] maze,
        SeaBattleGame game) {
        this.numRows = numRows;
        this.numCols = numCols;
        this.size = size;
        this.game = game;
        createGrid(maze);
    }

    /**
     * Populates the grid with a cell for each unique row/column combination and fills each cells based
     * on the speicified element to be in it.
     */
    private void createGrid(String[][] maze) {
        cells = new Cell[numRows][numCols];
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                String type = maze[i][j];
                Cell cell = new Cell(size);
                cell.getGraphics().setPosition(i * size, j * size);
                if (type.equals("B")) {
                    cell.addGraphics(new Wall(size, size));
                    cell.setTraversable(false);
                } else if (type.equals("C")) {
                  
                }
                this.add(cell.getGraphics());
                cells[i][j] = cell;
            }
        }
    }


}
