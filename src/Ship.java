import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Rectangle;
import java.awt.Color;

public class Ship extends GraphicsGroup {

    /***
     * Constructs a wall of specified width/height, which represents the ship.
     */
    public Ship() {
        super();

        Rectangle wall = new Rectangle(0, 0, 36, 36);
        this.add(wall);
        wall.setFillColor(Color.GRAY);
        wall.setStrokeColor(Color.BLACK);
    }

    /*
     * There will be 10 ships. 1 four length, 2 three length, 3 two length, 4 one length
     * The ships need randomly generated coordinates and direction such that it is not placed on another ship, or adjecent to another ship
     * 
     */
}
