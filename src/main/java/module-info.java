module com.example.trouristcompany {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.trouristcompany to javafx.fxml;
    exports com.example.trouristcompany;
}