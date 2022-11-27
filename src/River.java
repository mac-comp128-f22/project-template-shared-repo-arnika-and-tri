
import java.awt.Color;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Rectangle;

/**
 * Represents a single wall that forms that game's maze.
 */
public class River extends GraphicsGroup {

    /***
     * Constructs a wall of specified width/height.
     */
    public River(double wallWidth, double wallHeight) {
        Rectangle wall = new Rectangle(0, 0, wallWidth, wallHeight);
        this.add(wall);
        wall.setFillColor(Color.BLUE);
        wall.setStrokeColor(Color.BLACK);
    }
}
