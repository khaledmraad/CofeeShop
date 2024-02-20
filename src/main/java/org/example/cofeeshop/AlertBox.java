package org.example.cofeeshop;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.Control;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;


import java.io.IOException;

public class AlertBox {

    public static void display(String title,String message) {
        Stage window=new Stage();
        window.setTitle(title);
        window.initModality(Modality.APPLICATION_MODAL); //block user interaction until this is closed

        Label label1=new Label(message);

        Button closeButton=new Button("OK SRY");

        closeButton.setOnAction(e-> window.close());

        VBox pane=new VBox();

        pane.getChildren().addAll(label1,closeButton);

        pane.setAlignment(Pos.CENTER); // put everything in center

        Scene scene = new Scene(pane,300,300);



        window.setScene(scene);


        window.showAndWait();//before returning this window should be closed
    }

}
