import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Rectangle;
import java.awt.Color;

/**
 * A single cell representing a part of the ship.
 */
public class Ship extends GraphicsGroup {

    /***
     * Constructs a square of specified width/height, which represents the ship.
     */
    public Ship() {
        super();

        Rectangle wall = new Rectangle(0, 0, 36, 36);
        this.add(wall);
        wall.setFillColor(Color.GRAY);
        wall.setStrokeColor(Color.BLACK);
    }
}
