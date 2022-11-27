module com.example.storage {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.storage to javafx.fxml;
    exports com.example.storage;
}