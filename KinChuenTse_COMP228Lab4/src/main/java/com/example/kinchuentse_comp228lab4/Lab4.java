package com.example.kinchuentse_comp228lab4;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javafx.scene.Parent;

import java.io.IOException;
import java.util.Objects;

public class Lab4 extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Lab4-view.fxml")));
        stage.setTitle("Student Information System");
        stage.setScene(new Scene(root, 1050, 365));
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}