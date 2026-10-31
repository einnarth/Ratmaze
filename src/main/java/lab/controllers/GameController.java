package lab.controllers;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import lab.DrawingThread;
import lab.Level;

public class GameController {

    @FXML
    private Label scoreLabel;

    @FXML
    private Canvas canvas;

    private static GameController instance;

    public GameController() {
        instance = this;
    }

    @FXML
    public void initialize() {
        if (canvas != null) {
            Level level = new Level(canvas.getWidth(), canvas.getHeight());
            level.setScoreListener(GameController::updateScore);
            DrawingThread timer = new DrawingThread(canvas, level);
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
