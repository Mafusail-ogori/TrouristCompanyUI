package gui;

import data.*;
import human.User;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.fxml.Initializable;
import touristAttraction.*;

import java.io.IOException;
import java.net.URL;
import java.util.*;

import static data.AdminData.banUser;
import static data.AdminData.unBanUser;
import static data.TouristAttractionsData.convertToBoolean;

public class SceneController implements Initializable {
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
    @FXML
    protected TextField newPrice;
    @FXML
    protected ComboBox<String> choosePeriod = new ComboBox<>();
    @FXML
    protected ComboBox<String> chooseChildren = new ComboBox<>();
    @FXML
    protected ComboBox<String> chooseTransfer = new ComboBox<>();
    @FXML
    protected ComboBox<String> chooseType = new ComboBox<>();
    @FXML
    protected ComboBox<String> choosePet = new ComboBox<>();
    @FXML
    protected ComboBox<String> chooseNoise = new ComboBox<>();
    @FXML
    protected ComboBox<String> chooseParty = new ComboBox<>();
    @FXML
    protected ComboBox<String> chooseMeal = new ComboBox<>();
    @FXML
    protected ComboBox<String> chooseSorting = new ComboBox<>();
    @FXML
    protected ComboBox<String> chooseHotelRating = new ComboBox<>();
    @FXML
    protected TableView<TouristTicket> userResult = new TableView<>();
    @FXML
    protected TableColumn<TouristTicket, String> userResultName = new TableColumn<>();
    @FXML
    protected TableColumn<TouristTicket, Integer> userResultPeriod = new TableColumn<>();
    @FXML
    protected TableColumn<TouristTicket, Integer> userResultHotelRating = new TableColumn<>();
    @FXML
    protected TableColumn<TouristTicket, String> userResultMeal = new TableColumn<>();
    @FXML
    protected TableColumn<TouristTicket, Double> userResultPrice = new TableColumn<>();
    @FXML
    protected TableColumn<TouristTicket, String> userResultTransfer = new TableColumn<>();
    @FXML
    protected TableColumn<TouristTicket, String> userResultType = new TableColumn<>();
    @FXML
    protected TableView<User> userTable = new TableView<>();
    @FXML
    protected TableColumn<User, String> userTableNickname = new TableColumn<>();
    @FXML
    protected TableColumn<User, String> userTableRealname = new TableColumn<>();
    @FXML
    protected TableColumn<User, String> userTableEmail = new TableColumn<>();
    @FXML
    protected TableColumn<User, Boolean> userTableBanStatus = new TableColumn<User, Boolean>();


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

    public void switchToAdminStarter(ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("adminStarter.fxml")));
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToAdminSignUp(ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("signUpAdmin.fxml")));
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToBanUser(ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("banUser.fxml")));
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToDeleteTicket(ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("deleteTicket.fxml")));
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToAddTicket(ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("addTicket.fxml")));
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToAlterTicket(ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("alterTicket.fxml")));
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void getLoginData() throws IOException {
        if (new UserData().logIn(userLogInUserName.getText(), userLogInPassword.getText())) {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("userOptions.fxml")));
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

    public void getAdminLoginData() throws IOException {
        if (new AdminData().logIn(userLogInUserName.getText(), userLogInPassword.getText())) {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("adminStarter.fxml")));
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

    public void getSignUpAdminData() throws IOException {
        if (new AdminData().signUp(userSignUpUserName.getText(), userSignUpRealName.getText(),
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

    public void closeStage(ActionEvent actionEvent) {
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.close();
    }

    public void getDeleteData() throws IOException {
        if (new UserData().deleteAccount(userLogInUserName.getText(), userLogInPassword.getText())) {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("deletedSuccessfully.fxml")));
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

    public void getUserChoice() throws IOException {
        String answers = choosePeriod.getValue() + " " + chooseChildren.getValue() +
                " " + chooseTransfer.getValue() + " " + chooseType.getValue() +
                " " + choosePet.getValue() + " " + chooseNoise.getValue() +
                " " + chooseParty.getValue() + " " + chooseMeal.getValue();
        if (new TouristAttractionsData().quiz(answers) != null) {
            userResult.setItems(new TouristAttractionsData().quiz(answers));
        } else {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("somethingWentWrong.fxml")));
            stage = new Stage();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }

    }

    public void addNewTicket() throws IOException {
        Random random = new Random();
        if (new TouristAttractionDataBase().addToDataBase(TouristTicketTitle.getRandomTitle(), Integer.parseInt(choosePeriod.getValue()),
                random.nextInt(1, 11), String.valueOf(convertToBoolean(chooseChildren.getValue())),
                String.valueOf(convertToBoolean(choosePet.getValue())), String.valueOf(convertToBoolean(chooseNoise.getValue())),
                String.valueOf(convertToBoolean(chooseParty.getValue())), chooseType.getValue(),
                random.nextDouble(250.5, 12000), random.nextInt(1, 6),
                chooseTransfer.getValue(), chooseMeal.getValue())) {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("addedSuccessfully.fxml")));
        } else {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("somethingWentWrong.fxml")));
        }
        stage = new Stage();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void deleteTicket() {
        List<TouristTicket> touristTickets = new ArrayList<>();
        new TouristAttractionDataBase().getFromDataBase(touristTickets);
        new TouristAttractionDataBase().deleteFromDataBase(touristTickets.get(userResult.getSelectionModel().getSelectedIndex()).ticketId);
    }

    public void banTableUser() {
        List<User> userList = new ArrayList<>();
        new UserAdminDataBase().getDatabaseUsers(userList);
        banUser(userList.get(userTable.getSelectionModel().getSelectedIndex()));
    }

    public void unbanUser() {
        List<User> userList = new ArrayList<>();
        new UserAdminDataBase().getDatabaseUsers(userList);
        unBanUser(userList.get(userTable.getSelectionModel().getSelectedIndex()));
    }

    public void getUserTableData() {
        List<User> userList = new ArrayList<>();
        userTable.setItems(new UserAdminDataBase().getDatabaseUsers(userList));
    }

    public void getAllTickets() {
        var touristTickets = new TouristAttractionsData();
        switch (chooseSorting.getValue()) {
            case "Sort by rating" -> touristTickets.sortByRating();
            case "Sort by price" -> touristTickets.sortByPrice();
            case "Sort by period" -> touristTickets.sortByPeriod();
            case "Do not sort" -> new TouristAttractionDataBase().getFromDataBase(touristTickets.getTouristTickets());
        }
        userResult.setItems(FXCollections.observableArrayList(touristTickets.getTouristTickets()));
    }

    public void alterTicket() {
        List<TouristTicket> touristTickets = new ArrayList<>();
        new TouristAttractionDataBase().getFromDataBase(touristTickets);
        new TouristAttractionDataBase().alterTicket(touristTickets.get(userResult.getSelectionModel().getSelectedIndex()).ticketId, Integer.parseInt(newPrice.getText()),
                Integer.parseInt(chooseHotelRating.getValue()), chooseMeal.getValue(), chooseTransfer.getValue());
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        choosePeriod.setItems(FXCollections.observableArrayList("3", "4", "5", "6", "7", "8", "9", "10",
                "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25",
                "26", "27", "28"));
        chooseChildren.setItems(FXCollections.observableArrayList("Yes", "No"));
        chooseTransfer.setItems(FXCollections.observableArrayList("Car", "Bus", "Train", "Plane", "Ship", "Starship", "Horse"));
        chooseType.setItems(FXCollections.observableArrayList("Resort", "Excursion", "Healing", "Shopping", "Cruise"));
        choosePet.setItems(FXCollections.observableArrayList("Yes", "No"));
        chooseNoise.setItems(FXCollections.observableArrayList("Yes", "No"));
        chooseParty.setItems(FXCollections.observableArrayList("Yes", "No"));
        chooseMeal.setItems(FXCollections.observableArrayList("Breakfast", "TwoTimes", "ThreeTimes", "AllInclusiveNoAlco",
                "AllInclusiveAlco"));

        chooseSorting.setItems(FXCollections.observableArrayList("Sort by rating", "Sort by price", "Sort by period", "Do not sort"));
        chooseHotelRating.setItems(FXCollections.observableArrayList("1", "2", "3", "4", "5"));

        userResultName.setCellValueFactory(new PropertyValueFactory<TouristTicket, String>("title"));
        userResultPeriod.setCellValueFactory(new PropertyValueFactory<TouristTicket, Integer>("period"));
        userResultHotelRating.setCellValueFactory(new PropertyValueFactory<TouristTicket, Integer>("hotelRating"));
        userResultMeal.setCellValueFactory(new PropertyValueFactory<TouristTicket, String>("mealType"));
        userResultPrice.setCellValueFactory(new PropertyValueFactory<TouristTicket, Double>("price"));
        userResultTransfer.setCellValueFactory(new PropertyValueFactory<TouristTicket, String>("transportationType"));
        userResultType.setCellValueFactory(new PropertyValueFactory<TouristTicket, String>("ticketType"));

        userTableNickname.setCellValueFactory(new PropertyValueFactory<User, String>("nickName"));
        userTableRealname.setCellValueFactory(new PropertyValueFactory<User, String>("realName"));
        userTableEmail.setCellValueFactory(new PropertyValueFactory<User, String>("emailaddress"));
        userTableBanStatus.setCellValueFactory(new PropertyValueFactory<User, Boolean>("isBanned"));
    }
}