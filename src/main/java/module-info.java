module com.example.trouristcompany {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires log4j;


    opens gui to javafx.fxml;
    exports gui;

    opens touristAttraction to javafx.fxml;
    exports touristAttraction;

    opens human to javafx.fxml;
    exports human;
}