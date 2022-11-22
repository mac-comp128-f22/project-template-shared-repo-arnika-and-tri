
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Rectangle;

/**
 * Represents a single cell in the maze's grid.
 */
public class Cell {
    private GraphicsGroup graphics;
    private Rectangle rectangle;
    private boolean isTraversable;

    /**
     * Constructs an instance of a cell that is a square of a speicifed width/height.
     */
    public Cell(double size) {
        graphics = new GraphicsGroup();
        rectangle = new Rectangle(0, 0, size, size);
        graphics.add(rectangle);
        isTraversable = true;
    }

    /**
     * Checks if an object (whether it be player or ghost) can enter the cell.
     * 
     * @return true if it can, false if it cannot.
     */
    public boolean getTraversable() {
        return isTraversable;
    }

    /**
     * Changes whether or not an object can enter the cell based on the inputted value.
     */
    public void setTraversable(boolean isTraversable) {
        this.isTraversable = isTraversable;
    }

    /**
     * Returns the graphics in the cell.
     */
    public GraphicsGroup getGraphics() {
        return graphics;
    }

    /**
     * Adds a particular graphic to be added into the GraphicsGroup.
     */
    public void addGraphics(GraphicsGroup group) {
        group.setCenter(rectangle.getCenter());
        graphics.add(group);
    }

}
