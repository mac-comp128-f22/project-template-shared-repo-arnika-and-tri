
import java.awt.Color;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Rectangle;

/**
 * Represents a single wall that forms that game's maze.
 */
public class River extends GraphicsGroup {
    public Rectangle river;
    /***
     * Constructs a wall of specified width/height.
     */
    public River(double riverWidth, double riverHeight) {
        river = new Rectangle(0, 0, riverWidth, riverHeight);
        this.add(river);
        river.setFillColor(Color.BLUE);
        river.setStrokeColor(Color.BLACK);
    }

    public void setColor(){
        river.setFillColor(Color.RED);
    }
}
