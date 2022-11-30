
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Rectangle;

/**
 * Represents a single cell in the maze's grid.
 */
public class Cell {
    private GraphicsGroup graphics;
    private Rectangle rectangle;
    private River river;
    private Ship ship;

    /**
     * Constructs an instance of a cell that is a square of a speicifed width/height.
     */
    public Cell(double size) {
        graphics = new GraphicsGroup();
        rectangle = new Rectangle(0, 0, size, size);
        graphics.add(rectangle);
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

    public void removeRiver() {
        graphics.remove(river);
    }

    public void removeShip() {
        graphics.remove(ship);
    }


}
