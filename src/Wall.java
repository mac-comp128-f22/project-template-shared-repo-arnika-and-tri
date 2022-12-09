
import java.awt.Color;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Rectangle;

/**
 * A single cell representing the wall between the player and opponent ships.
 */
public class Wall extends GraphicsGroup {
    public Rectangle wall;
    
    /***
     * Constructs a square of specified width/height, colored black.
     */
    public Wall(double wallWidth, double wallHeight) {
        this.wall = new Rectangle(0, 0, wallWidth, wallHeight);
        this.add(wall);
        wall.setFillColor(Color.BLACK);
    }


}
