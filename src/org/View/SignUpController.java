package org.View;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.DAO.userDAO;
import org.Domain.user;
import org.Service.config;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Objects;

public class SignUpController {

    config c=new config();


    @FXML
    private TextField userNameField;
    @FXML
    private TextField userEmailField;
    @FXML
    private TextField userPassField;
    @FXML
    private TextField userConfirmPassField;

    @FXML
    private Button signupButton;

    private Stage stage;
    private Scene scene;



    @FXML
    protected void outputText(ActionEvent event) throws IOException {
        System.out.println("clicked");
        if (userNameField.getText().isEmpty()
                || userEmailField.getText().isEmpty()
                || userPassField.getText().isEmpty()
                || userConfirmPassField.getText().isEmpty()) {
            AlertBox.display("im serieussss", "complete ur input bro");
            return;
        }

        String userName = userNameField.getText();
        String userEmail = userEmailField.getText();
        String userPass = userPassField.getText();
        String userConfirmPass = userConfirmPassField.getText();

        if (!Objects.equals(userPass, userConfirmPass)) {
            AlertBox.display("BRO??", "password dont match the confirm password");
            return;
        }

        if (userDAO.userExist(userName,userEmail,userPass)) {
            AlertBox.display("user already pwned", "change smth to signup");
            return;
        }

        user u=new user(userName,userEmail,userPass);

        userDAO uDao=new userDAO(u);

        c.getSession().beginTransaction();

        uDao.CreateU();

        c.getSession().getTransaction().commit();

        AlertBox.display("user pwned", "ur signup successfully ");

        Parent root= FXMLLoader.load(getClass().getResource("../../resourcesss/HomePage.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();


    }


}