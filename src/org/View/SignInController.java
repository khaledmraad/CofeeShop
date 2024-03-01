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

import java.io.IOException;
import java.sql.*;

public class SignInController {

    private static final String db_url = "jdbc:mysql://localhost:3306/CofeeShop";
    private static final String db_username = "root";
    private static final String db_password = "";
    private static final String select_query = "SELECT * FROM users_cred WHERE name=? AND password=?";

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

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Drivers loaded!");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost/CofeeShop","root","");
            Statement stmt = con.createStatement();
            String sql = "SELECT * FROM users_cred WHERE name='"+userName+"' AND password='"+userPass+"'";
            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()){
                AlertBox.display("congratss", "u exist");
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene = HomePage.homeScene(stage);
                stage.setScene(scene);

            }
            else {
                AlertBox.display("XD", "u dont exist");

            }

        } catch (SQLException e) {
            e.printStackTrace();
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