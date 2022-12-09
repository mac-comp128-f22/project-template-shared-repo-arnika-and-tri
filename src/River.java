
import java.awt.Color;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Rectangle;

/**
 * A single cell representing the river.
 */
public class River extends GraphicsGroup {

    /***
     * Constructs a sqaure of specified width/height with blue color, which represents the river.
     */
    public River(double size) {
        Rectangle river = new Rectangle(0, 0, size, size);
        this.add(river);
        river.setFillColor(Color.BLUE);
        river.setStrokeColor(Color.BLACK);
    }

}
