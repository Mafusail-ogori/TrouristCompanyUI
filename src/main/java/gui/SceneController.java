package gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class SceneController {
    protected Stage stage;
    protected Scene scene;
    protected Parent root;

    public void switchToStarterScene(ActionEvent actionEvent) throws IOException {
        this.root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Starter.fxml")));
        this.stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        this.scene = new Scene(root);
        stage.show();
    }

    public void switchToLoggingScene(ActionEvent actionEvent) throws IOException {
        this.root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("entrance.fxml")));
        this.stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        this.scene = new Scene(root);
        stage.show();
    }
}