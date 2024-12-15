import edu.macalester.graphics.GraphicsGroup;

/**
 * Represents a grid of cells that is populated to form the maze and all its elements (coins,
 * ghosts, walls and player).
 */
public class Grid extends GraphicsGroup {
    protected int numRows, numCols;
    protected double size;
    public static Cell[][] cells;

    /**
     * Initializes a grid with a speicified number of rows and columns and overall size.
     */
    public Grid(int numCols, int numRows, int size, String[][] maze) {
        this.numRows = numRows;
        this.numCols = numCols;
        this.size = size;
        createGrid(maze);
    }

    /**
     * Populates the grid with a cell for each unique row/column combination and fills each cells based
     * on the speicified visual element to be in it (for example, ship, wall or river).
     */
    private void createGrid(String[][] populatedGrid) {
        cells = new Cell[numCols][numRows];
        for (int i = 0; i < numCols; i++) {
            for (int j = 0; j < numRows; j++) {
                String type = populatedGrid[i][j];
                Cell cell = new Cell(size);
                cell.getGraphics().setPosition(i * size, j * size);
                if (type.equals("W")) {
                    cell.addGraphics(new Wall(size));
                } else if (type.equals("S") && j > 10) {
                    cell.addGraphics(new River(size));
                } else if (type.equals("S")) {
                    cell.addGraphics(new Ship(size));
                } else if (type.equals("R")) {
                    cell.addGraphics(new River(size));
                }
                this.add(cell.getGraphics());
                cells[i][j] = cell;
            }
        }
    }

    /**
     * Change the cell status and color after being shot by a missile. It is considered a correct shot
     * if an opponent's ship is hit, and wrong shoot if its hits the river.
     */
    public GraphicsGroup setCellGraphics(int row, int col, String type) {
        if (type.equals("C")) { // correct shooting
            cells[row][col].getGraphics().add(new CorrectShot(size));
        } else if (type.equals("W")) {
            cells[row][col].getGraphics().add(new WrongShot(size));
        }
        cells[row][col].getGraphics().setPosition(row * size, col * size);
        return cells[row][col].getGraphics();
    }
}
