package lab;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.util.HashSet;
import java.util.Set;

/**
 * Class <b>App</b> - extends class Application and it is an entry point of the program
 *
 * @author Java I
 */
public class App extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    public static Set<KeyCode> activeKeys = new HashSet<>();
    private Canvas canvas;
    private static Stage mainStage;
    private static AnimationTimer timer;

    @Override
    public void start(Stage primaryStage) {
        try {
            mainStage = primaryStage;
            FXMLLoader loader = new FXMLLoader(App.class.getResource("menu.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root, 800, 400);
            mainStage.setScene(scene);
            mainStage.setResizable(false);
            mainStage.setTitle("Ratmaze - Menu");
            mainStage.show();
            mainStage.setOnCloseRequest(this::exitProgram);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void startGame() {
        try {
            javafx.fxml.FXMLLoader loader = new javafx.fxml.FXMLLoader(App.class.getResource("game.fxml"));
            javafx.scene.Parent root = loader.load();

            javafx.scene.Scene scene = new javafx.scene.Scene(root, 800, 400);
            scene.getStylesheets().add(App.class.getResource("application.css").toExternalForm());

            scene.setOnKeyPressed(event -> activeKeys.add(event.getCode()));
            scene.setOnKeyReleased(event -> activeKeys.remove(event.getCode()));

            mainStage.setScene(scene);
            mainStage.setTitle("Ratmaze");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void stop() throws Exception {
        if (timer != null) {
            timer.stop();
        }
        super.stop();
    }

    private void exitProgram(WindowEvent evt) {
        System.exit(0);
    }
}
