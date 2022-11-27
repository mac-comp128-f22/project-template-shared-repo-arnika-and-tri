
import java.awt.Color;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Rectangle;

/**
 * Represents a single wall that forms that game's maze.
 */
public class Wall extends GraphicsGroup {

    /***
     * Constructs a wall of specified width/height.
     */
    public Wall(double wallWidth, double wallHeight) {
        Rectangle wall = new Rectangle(0, 0, wallWidth, wallHeight);
        this.add(wall);
        wall.setFillColor(Color.BLACK);
    }
}
