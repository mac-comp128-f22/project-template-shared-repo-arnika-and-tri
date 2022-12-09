
import java.awt.Color;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Rectangle;

/**
 * Represents a cell holding a ship that has been hit.
 */
public class CorrectShot extends GraphicsGroup {

    /***
     * Constructs a sqaure of specified width/height with green color, which represents a proper shoot on
     * the ship.
     */
    public CorrectShot(double size) {
        Rectangle hitSquare = new Rectangle(0, 0, size, size);
        this.add(hitSquare);
        hitSquare.setFillColor(Color.GREEN);


    }

}
