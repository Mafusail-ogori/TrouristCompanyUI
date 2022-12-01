package gui;

import data.UserData;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SceneController {
    protected Stage stage;
    protected Scene scene;
    protected Parent root;
    @FXML
    protected TextField userLogInUserName;
    @FXML
    protected TextField userLogInPassword;
    @FXML
    protected TextField userSignUpUserName;
    @FXML
    protected TextField userSignUpRealName;
    @FXML
    protected TextField userSignUpPassword;
    @FXML
    protected TextField userSignUpEmailAddress;


    public void switchToStarterScene(ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("starter.fxml")));
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToLoggingScene(ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("entrance.fxml")));
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToUserScene(ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("userStarter.fxml")));
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToLogInScene(ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("logIn.fxml")));
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToSignUpScene(ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("signUp.fxml")));
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToDeleteAccount(ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("deleteAccount.fxml")));
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToAdminLogIn(ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("adminLogIn.fxml")));
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToAdminOptions(ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("adminStarter.fxml")));
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene); // develop all the admin functionality
        stage.show();
    }

    public void switchToUserOptions(ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("userOptions.fxml")));
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void getLoginData() throws IOException {
        if (new UserData().logIn(userLogInUserName.getText(), userLogInPassword.getText())) {
            root = new Group();
        } else {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("somethingWentWrong.fxml")));
        }
        stage = new Stage();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();


        userLogInPassword.clear();
        userLogInUserName.clear();
    }

    public void getSignUpData() throws IOException {
        if (new UserData().signUp(userSignUpUserName.getText(), userSignUpRealName.getText(),
                userSignUpPassword.getText(), userSignUpEmailAddress.getText())) {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("signedUpSuccessfully.fxml")));
        } else {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("somethingWentWrong.fxml")));
        }
        stage = new Stage();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();


        userSignUpUserName.clear();
        userSignUpRealName.clear();
        userSignUpPassword.clear();
        userSignUpEmailAddress.clear();
    }

    public void getDeleteData() throws IOException {
        if (new UserData().deleteAccount(userLogInUserName.getText(), userLogInPassword.getText())) {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("deletedSuccessfully.fxml")));
        }
        else{
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("somethingWentWrong.fxml")));
        }
        stage = new Stage();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

        userLogInPassword.clear(); //if called successfully, give the way to another window, or back to log in
        userLogInUserName.clear();
    }
}