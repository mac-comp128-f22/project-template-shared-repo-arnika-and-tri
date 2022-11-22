import java.util.Random;

import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Image;

public class Ship extends GraphicsGroup {
    private Image shipIcon;
    private String shipNum;
    private int shipRow;
    private int shipCol;
    private int size;
    private int direction;
    private Random random;

    public Ship(String shipNum, int size) {
        super();
    
        this.shipNum = shipNum;
        this.size = size;

        random = new Random();
        direction = chooseRandomDirection();
        shipRow = setShipRow();
        shipCol = setShipCol();

        setImage(size);
        add(shipIcon);
    }

    public void setImage(int size) {
        shipIcon = new Image("shipSize"+ size + ".png");
        // shipIcon.setMaxWidth(squareSize * size);
        // shipIcon.setMaxHeight(squareSize * size);
    }

    public int chooseRandomDirection() {
        return random.nextInt(4);
    }

    public int getShipDirection() {
        return direction;
    }

    public int setShipRow() {
        // fix
        // from coordinates in grid != ship, or ship adjacent choose a topleft most coordinate randomly 
        // 
        return shipRow;
    }

    public int setShipCol() {
        // fix 
        return shipCol;
    }

    public int getShipRow() {
        return shipRow;
    }

    public int getShipCol() {
        return shipCol;
    }

    /*
     * There will be 10 ships. 1 four length, 2 three length, 3 two length, 4 one length
     * The ships need randomly generated coordinates and direction such that it is not placed on another ship, or adjecent to another ship
     * 
     */
}