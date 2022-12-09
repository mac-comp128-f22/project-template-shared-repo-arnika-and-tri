
import java.awt.Color;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Rectangle;

/**
 * Represents a cell holding an instance of the river that has been hit.
 */
public class WrongShooted extends GraphicsGroup {
    public Rectangle wall;

    /***
     * Constructs a sqaure of specified width/height with red color, which represents an incorrect hit. 
     */
    public WrongShooted(double wallWidth, double wallHeight) {
        this.wall = new Rectangle(0, 0, wallWidth, wallHeight);
        this.add(wall);
        wall.setFillColor(Color.RED);

    }

}
