
import java.awt.Color;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Rectangle;

/**
 * Represents a single wall that forms that game's maze.
 */
public class WrongShooted extends GraphicsGroup {
    public Rectangle wall;

    /***
     * Constructs a wall of specified width/height.
     */
    public WrongShooted(double wallWidth, double wallHeight) {
        this.wall = new Rectangle(0, 0, wallWidth, wallHeight);
        this.add(wall);
        wall.setFillColor(Color.RED);


    }

}
