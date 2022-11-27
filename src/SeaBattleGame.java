import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsText;
import edu.macalester.graphics.Rectangle;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.FontStyle;
import edu.macalester.graphics.GraphicsText;


public class SeaBattleGame {
    private static final int CANVAS_WIDTH = 720;
    private static final int CANVAS_HEIGHT = 750;
    private Grid grid;
    private CanvasWindow canvas;
    private HomeScreen screens;
    private String[][] maze;
    private int tracker;
    private GraphicsText gameStatus;
    private int numOfCoins;
    private boolean playingGame;
    // private static final = 720;


    public SeaBattleGame() {
        canvas = new CanvasWindow("Sea Battle", 750, 750);
        canvas.setBackground(Color.WHITE);
        screens = new HomeScreen(canvas, this);
        screens.homeScreen();

    }

    public void playingScreen() {
        numOfCoins = 310;
        settingUpGame();
        grid = new Grid(28, 24, 30, maze, this);
        canvas.add(grid);
        canvas.onMouseDown(event-> {
            if(event.getClass().toString().equals("Rectangle")){
                event.get
            }
        });
    }

    private void settingUpGame() {
        generateMaze();
        playingGame = true;
        canvas.draw();
    }


    private void generateMaze() {
        maze = new String[28][24];
        maze[0] = new String[] { "B", "B", "B", "B", "B", "B", "C", "C", "C", "B", "B", "B", "B", "B", "B", "B", "B",
            "B", "B", "B", "B", "B", "B", "B" };
        maze[1] = new String[] { "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B",
            "B", "B", "B", "B", "B", "B", "B" };
        maze[2] = new String[] { "B", "B", "B", "B", "B", "B", "B", "C", "B", "B", "B", "B", "B", "B", "B", "B", "B",
            "B", "B", "B", "B", "B", "B", "B" };
        maze[3] = new String[] { "B", "B", "B", "B", "B", "B", "B", "C", "B", "B", "B", "B", "B", "B", "B", "B", "B",
            "B", "B", "B", "B", "B", "B", "B" };
        maze[4] = new String[] { "B", "B", "B", "B", "B", "B", "B", "C", "B", "B", "B", "B", "B", "B", "B", "B", "B",
            "B", "B", "B", "B", "B", "B", "B" };
        maze[5] = new String[] { "B", "B", "B", "B", "B", "B", "B", "C", "B", "B", "B", "B", "B", "B", "B", "B", "B",
            "B", "B", "B", "B", "B", "B", "B" };
        maze[6] = new String[] { "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B",
            "B", "B", "B", "B", "B", "B", "B" };
        maze[7] = new String[] { "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B",
            "B", "B", "B", "B", "B", "B", "B" };
        maze[8] = new String[] { "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B",
            "B", "B", "B", "B", "B", "B", "B" };
        maze[9] = new String[] { "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B",
            "B", "B", "B", "B", "B", "B", "B" };
        maze[10] = new String[] { "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B",
            "B", "B", "B", "B", "B", "B", "B" };
        maze[11] = new String[] { "B", "B", "B", "B", "B", "C", "C", "C", "C", "B", "B", "B", "B", "B", "B", "B", "B",
            "B", "B", "B", "B", "B", "B", "B" };
        maze[12] = new String[] { "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R",
            "R", "R", "R", "R", "R", "R", "R" };
        maze[13] = new String[] { "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R",
            "R", "R", "R", "R", "R", "R", "R" };
        maze[14] = new String[] { "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R",
            "R", "R", "R", "R", "R", "R", "R" };
        maze[15] = new String[] { "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R",
            "R", "R", "R", "R", "R", "R", "R" };
        maze[16] = new String[] { "B", "B", "B", "B", "B", "B", "B", "C", "C", "C", "C", "C", "C", "C", "C", "B", "B",
            "B", "B", "B", "B", "B", "B", "B" };
        maze[17] = new String[] { "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B",
            "B", "B", "B", "B", "B", "B", "B" };
        maze[18] = new String[] { "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B",
            "B", "B", "B", "B", "B", "B", "B" };
        maze[19] = new String[] { "B", "B", "B", "B", "C", "C", "C", "C", "B", "B", "B", "B", "B", "B", "B", "B", "B",
            "B", "B", "B", "B", "B", "B", "B" };
        maze[20] = new String[] { "B", "B", "B", "B", "B", "B", "B", "B", "B", "C", "B", "B", "B", "B", "B", "B", "B",
            "B", "B", "B", "B", "B", "B", "B" };
        maze[21] = new String[] { "B", "B", "B", "B", "B", "B", "B", "B", "B", "C", "B", "B", "B", "B", "B", "B", "B",
            "B", "B", "B", "B", "B", "B", "B" };
        maze[22] = new String[] { "B", "B", "B", "B", "B", "B", "B", "B", "B", "C", "B", "B", "B", "B", "B", "B", "B",
            "B", "B", "B", "B", "B", "B", "B" };
        maze[23] = new String[] { "B", "B", "B", "B", "B", "B", "B", "B", "B", "C", "B", "B", "B", "B", "B", "B", "B",
            "B", "B", "B", "B", "B", "B", "B" };
        maze[24] = new String[] { "B", "B", "B", "B", "B", "B", "B", "B", "B", "C", "B", "B", "B", "B", "B", "B", "B",
            "B", "B", "B", "B", "B", "B", "B" };
        maze[25] = new String[] { "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B",
            "B", "B", "B", "B", "B", "B", "B" };
        maze[26] = new String[] { "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B",
            "B", "B", "B", "B", "B", "B", "B" };
        maze[27] = new String[] { "B", "C", "C", "C", "C", "B", "B", "B", "C", "C", "C", "C", "B", "B", "B", "B", "B",
            "B", "B", "B", "B", "B", "B", "B" };
    }


    public static void main(String[] args) {
        new SeaBattleGame();
    }
}
