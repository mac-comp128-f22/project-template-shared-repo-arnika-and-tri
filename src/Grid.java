import java.awt.Color;

import edu.macalester.graphics.GraphicsGroup;

/**
 * Represents a grid of cells that is populated to form the maze and all its elements (coins,
 * ghosts, walls and player).
 */
public class Grid extends GraphicsGroup {
    protected int numRows, numCols;
    protected double size;
    private SeaBattleGame game;
    public static Cell[][] cells;

    /**
     * Initializes a grid with a speicified number of rows and columns and overall size.
     */
    public Grid(int numCols, int numRows, int size, String[][] maze,
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
        cells = new Cell[numCols][numRows];
        for (int i = 0; i < numCols; i++) {
            for (int j = 0; j < numRows; j++) {
                String type = maze[i][j];
                Cell cell = new Cell(size);
                cell.getGraphics().setPosition(i * size, j * size);
                if (type.equals("W")) {
                    cell.addGraphics(new Wall(size, size));
                } else if (type.equals("S") && j > 10) {
                    cell.addGraphics(new River(size, size));
                } else if (type.equals("S")) {
                    cell.addGraphics(new Ship());
                } else if (type.equals("R")) {
                    cell.addGraphics(new River(size, size));
                } else if (type.equals("R")) {
                    cell.addGraphics(new River(size, size));
                } 
                this.add(cell.getGraphics());
                cells[i][j] = cell;
            }
        }
    }

    public GraphicsGroup setCellGraphics(int row, int col) {
        // Rectangle shot = new Rectangle(row * size, col * size, size, size);
        // shot.setFillColor(Color.RED);
        // cells[row][col].getGraphics().add(shot);
        cells[row][col].getGraphics().add(new Shooted(size, size));
        cells[row][col].getGraphics().setPosition(row * size, col * size);
        return cells[row][col].getGraphics();
    }
}
