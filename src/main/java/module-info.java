module ratmaze {
    requires transitive javafx.controls;
    requires javafx.fxml;
    requires javafx.base;
    opens lab.controllers to javafx.fxml;
    opens lab to javafx.fxml;
    exports lab;
}
