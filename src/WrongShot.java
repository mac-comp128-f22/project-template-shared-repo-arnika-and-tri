
import java.awt.Color;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Rectangle;

/**
 * Represents a cell holding an instance of the river that has been hit.
 */
public class WrongShot extends GraphicsGroup {

    /***
     * Constructs a sqaure of specified width/height with red color, which represents an incorrect hit.
     */
    public WrongShot(double size) {
        Rectangle hitSquare = new Rectangle(0, 0, size, size);
        this.add(hitSquare);
        hitSquare.setFillColor(Color.RED);

    }

}
