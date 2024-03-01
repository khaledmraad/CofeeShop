package org.View;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SignUpViewLoader extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(SignInViewLoader.class.getResource("SignInView.fxml"));
        if (fxmlLoader.getLocation() == null) {
            System.err.println("FXML file not found!");
            return;
        }
        Scene scene = new Scene(fxmlLoader.load(), 804, 553);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}