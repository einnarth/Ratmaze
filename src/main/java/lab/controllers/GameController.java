package lab.controllers;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import lab.DrawingThread;

public class GameController {

    @FXML
    private Label scoreLabel;

    @FXML
    private Canvas canvas;

    private static GameController instance;
    private DrawingThread timer;

    public GameController() {
        instance = this;
    }

    @FXML
    public void initialize() {
        if (canvas != null) {
            timer = new DrawingThread(canvas);
            timer.start();
        }
    }

    public static void updateScore(int score) {
        if (instance != null && instance.scoreLabel != null) {
            javafx.application.Platform.runLater(() ->
                instance.scoreLabel.setText("Score: " + score)
            );
        }
    }
}
