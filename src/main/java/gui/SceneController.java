package gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneController {
    protected Stage stage;
    protected Scene scene;
    protected Parent root;

    public void switchToScene(ActionEvent actionEvent){
        this.root = FXMLLoader.load(getClass().getResource("Starter.fxml"));

    }
}
