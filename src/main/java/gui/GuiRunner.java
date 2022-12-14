package gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

import static data.TouristAttractionsData.touristTicketGenerator;

public class GuiRunner extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("starter.fxml")));
        Scene scene = new Scene(root);
        stage.setTitle("Tourist company application");
        stage.getIcons().add(new Image("icon.png"));
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
//        touristTicketGenerator();
        launch();
    }
}