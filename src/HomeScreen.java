import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Image;

public class HomeScreen {
    private CanvasWindow canvas;
    private SeaBattleGame game;
    
    public HomeScreen(CanvasWindow canvas, SeaBattleGame game) {
        this.canvas = canvas;
        this.game = game;
    }

    public void homeScreen() {
        // titleImage();
        playButton();
        quitButton();
        // instructionsButton();
        // creditsButton();
    }

    private void playButton() {
        CustomButton playButton = new CustomButton("START");
        playButton.setCenter(canvas.getWidth() / 2 - 100, canvas.getHeight() / 2 + 10);
        Image playImage = new Image("sprite-icons/play.png");
        playImage.setCenter(canvas.getWidth() / 2 - 100, canvas.getHeight() / 2 + 10);
        playImage.setScale(0.3);
        canvas.add(playImage);
        canvas.add(playButton);
        playButton.onClick(() -> {
            canvas.removeAll();
            game.playingScreen();
        });
    }

    /**
     * Creates a "quit" button that when clicked, exits out and closes the game.
     */
    private void quitButton() {
        CustomButton quitButton = new CustomButton("QUIT");
        quitButton.setCenter(canvas.getWidth() / 2 + 100, canvas.getHeight() / 2 + 10);
        Image quitImage = new Image("sprite-icons/quit.png");
        quitImage.setCenter(canvas.getWidth() / 2 + 100, canvas.getHeight() / 2 + 10);
        quitImage.setScale(0.3);
        canvas.add(quitImage);
        canvas.add(quitButton);
        quitButton.onClick(() -> canvas.closeWindow());
    }

    
}
