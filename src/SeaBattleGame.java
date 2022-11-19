import edu.macalester.graphics.CanvasWindow;

public class SeaBattleGame {
    private CanvasWindow canvas;
    // private static final  = 720;


    public SeaBattleGame() {
        canvas = new CanvasWindow("Sea Battle", 750, 750);

    }
    
    public static void main(String[] args) {
        new SeaBattleGame();
    }
}
