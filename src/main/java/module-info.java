module com.example.trouristcompany {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires log4j;


    opens gui to javafx.fxml;
    exports gui;
}