import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Image;
import edu.macalester.graphics.Point;
import edu.macalester.graphics.ui.TextField;

public class GameGUI {
    public static final int CANVAS_WIDTH = 396;
    public static final int CANVAS_HEIGHT = 828;

    private CanvasWindow canvas;
    private SeaBattleGame game;
    public TextField coordinateField1;
    public TextField coordinateField2;
    
    public GameGUI(CanvasWindow canvas, SeaBattleGame game) {
        this.canvas = canvas;
        this.game = game;
    }

    public void homeScreen() {
        playButton();
        quitButton();
    }

    private void playingScreen() {
        game.generateGrid();
        coordinateButtons();
        coordinateLabels();
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
            playingScreen();
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

    private void coordinateLabels() {
        Image rowNums = new Image("sprite-icons/col-nums.png");
        rowNums.setCenter(CANVAS_WIDTH - 17, CANVAS_HEIGHT - 250);
        rowNums.setScale(0.4);
        canvas.add(rowNums);

        Image columnLetter = new Image("sprite-icons/row-nums.png");
        columnLetter.setCenter(CANVAS_WIDTH / 2 - 20, CANVAS_HEIGHT - columnLetter.getHeight() / 2 - 28);
        columnLetter.setScale(0.4);
        canvas.add(columnLetter);
    }

    private void coordinateButtons() {
        coordinateField1 = new TextField();
        coordinateField1.setCenter(5 + coordinateField1.getWidth() / 2,
            CANVAS_HEIGHT - coordinateField1.getHeight() / 2 - 5);
        canvas.add(coordinateField1);

        coordinateField2 = new TextField();
        coordinateField2.setCenter(5 + coordinateField1.getWidth() + coordinateField2.getWidth() / 2,
            CANVAS_HEIGHT - coordinateField2.getHeight() / 2 - 5);
        canvas.add(coordinateField2);

        CustomButton coordinatesButton = new CustomButton("Enter coordinate: ");
        Point buttonPosition = new Point(
            40 + coordinateField1.getWidth() + coordinateField2.getWidth() + coordinatesButton.getWidth() / 2,
            CANVAS_HEIGHT - coordinatesButton.getHeight() / 2 - 5);
        coordinatesButton.setCenter(buttonPosition);
        canvas.add(coordinatesButton);

        Image coordinateImage = new Image("sprite-icons/coordinate-button.png");
        coordinateImage.setCenter(buttonPosition);
        coordinateImage.setScale(0.22);

        canvas.add(coordinateImage);

        coordinatesButton.onClick(() -> game.shootMissile());

    }

    /**
     * Creates a "win" screen that displays the "you win!" message.
     */
    public void winMessage() {
        canvas.removeAll();
        Image winImage = new Image("sprite-icons/win-message.png");
        winImage.setScale(0.8);
        winImage.setCenter(canvas.getWidth() / 2, canvas.getHeight() / 2.5);
        canvas.add(winImage);
        canvas.draw();
        canvas.pause(3000);
        canvas.closeWindow();
    }

    /**
     * Creates a "lose" screen that displays the "you lose" message.
     */
    public void loseMessage() {
        canvas.removeAll();
        Image loseImage = new Image("sprite-icons/lose-message.png");
        loseImage.setScale(0.8);
        loseImage.setCenter(canvas.getWidth() / 2, canvas.getHeight() / 2.5);
        canvas.add(loseImage);
        canvas.draw();
        canvas.pause(3000);
        canvas.closeWindow();
    }
}
