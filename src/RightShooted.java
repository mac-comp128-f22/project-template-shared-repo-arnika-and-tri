
import java.awt.Color;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Rectangle;

/**
 * Represents a cell holding a ship that has been hit.
 */
public class RightShooted extends GraphicsGroup {
    public Rectangle wall;

    /***
     * Constructs a sqaure of specified width/height with green color, which represents a proper shoot on
     * the ship.
     */
    public RightShooted(double wallWidth, double wallHeight) {
        this.wall = new Rectangle(0, 0, wallWidth, wallHeight);
        this.add(wall);
        wall.setFillColor(Color.GREEN);


    }

}
