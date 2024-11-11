module com.example.kinchuentse_comp228lab4 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.kinchuentse_comp228lab4 to javafx.fxml;
    exports com.example.kinchuentse_comp228lab4;
}