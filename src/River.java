
import java.awt.Color;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Rectangle;

/**
 * A single cell representing the river.
 */
public class River extends GraphicsGroup {
    public Rectangle river;

    /***
     * Constructs a sqaure of specified width/height with blue color, which represents the river. 
     */
    public River(double riverWidth, double riverHeight) {
        river = new Rectangle(0, 0, riverWidth, riverHeight);
        this.add(river);
        river.setFillColor(Color.BLUE);
        river.setStrokeColor(Color.BLACK);
    }

}
