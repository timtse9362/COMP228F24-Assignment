module com.example.kinchuentse_comp228lab5 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires ojdbc8;
    requires java.desktop;


    opens com.example.kinchuentse_comp228lab5 to javafx.fxml;
    exports com.example.kinchuentse_comp228lab5;
}