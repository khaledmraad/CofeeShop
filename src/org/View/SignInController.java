package org.View;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.DAO.userDAO;

import java.io.IOException;
import java.sql.*;

public class SignInController {

    @FXML
    private Label welcomeText;

    @FXML
    private TextField userNameField;
    @FXML
    private TextField userPassField;

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    protected void signIn(ActionEvent event) {
        if (userNameField.getText().isEmpty()
                || userPassField.getText().isEmpty()) {
            AlertBox.display("im serieussss", "complete ur input bro");
            return;
        }

        String userName = userNameField.getText();
        String userPass = userPassField.getText();


        if (!userDAO.userExist(userName,userPass)){
            AlertBox.display("NO NO NO NO", "go signup pls");
        }

        else{
            AlertBox.display("UR logged in ", "enter to best coffeeshop ever ");

            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = HomePage.homeScene(stage);
            stage.setScene(scene);
        }

    }

    @FXML
    protected void redirect(ActionEvent event) throws IOException {
        Parent root= FXMLLoader.load(getClass().getResource("../../resourcesss/SignUpView.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

}