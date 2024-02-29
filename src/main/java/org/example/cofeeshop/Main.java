package org.example.cofeeshop;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Main extends Application {

    Stage window;
    Button button;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        window=primaryStage;

        Label userName=new Label("UserName");

        TextField textField = new TextField ();

        VBox layout=new VBox();

        layout.getChildren().addAll(userName,textField);

        Scene scene =new Scene(layout,500,500);
        window.setScene(scene);
        window.show();


    }
}
