package org.View;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HomePage  {

    public static Scene homeScene(Stage primaryStage){
        VBox layout=new VBox();
        Button button=new Button();
        button.setText("click this");
        button.setOnAction(e->{
            System.out.println("noice");
        });

        Button closeButton = new Button("Close Window");
        closeButton.setOnAction(e -> primaryStage.close());


        layout.getChildren().addAll(button,closeButton);

        return new Scene(layout,300,300);

    }
}
