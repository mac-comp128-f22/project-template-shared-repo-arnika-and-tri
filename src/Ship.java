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
    public Ship(double size) {
        super();
        Rectangle shipSqaure = new Rectangle(0, 0, size, size);
        this.add(shipSqaure);
        shipSqaure.setFillColor(Color.GRAY);
        shipSqaure.setStrokeColor(Color.BLACK);
    }
}
