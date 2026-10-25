package lab.controllers;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class MenuController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button exitButton;

    @FXML
    private VBox menuContainer;

    @FXML
    private Button startButton;

    @FXML
    private Label titleLabel;

    @FXML
    void onExitClick(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void onStartClick(ActionEvent event) {
        lab.App.startGame();
    }

    @FXML
    void initialize() {
        assert exitButton != null : "fx:id=\"exitButton\" was not injected: check your FXML file 'menu.fxml'.";
        assert menuContainer != null : "fx:id=\"menuContainer\" was not injected: check your FXML file 'menu.fxml'.";
        assert startButton != null : "fx:id=\"startButton\" was not injected: check your FXML file 'menu.fxml'.";
        assert titleLabel != null : "fx:id=\"titleLabel\" was not injected: check your FXML file 'menu.fxml'.";

    }

}
