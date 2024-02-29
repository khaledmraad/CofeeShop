package org.example.cofeeshop;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Scene;


import java.sql.*;
import java.util.Objects;

public class SignUpController {
    private static final String db_url = "jdbc:mysql://localhost:3306/CofeeShop";
    private static final String db_username = "root";
    private static final String db_password = "";
    private static final String insert_query = "INSERT INTO users_cred (name, email, password) VALUES (?, ?, ?)";

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
    protected void outputText(ActionEvent event) {
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
            AlertBox.display("ru blind?xd", "password dont match the confirm password");
            return;
        }

        try (Connection connection = DriverManager
                .getConnection(db_url, db_username, db_password);

             PreparedStatement preparedStatement = connection.prepareStatement(insert_query)) {
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, userEmail);
            preparedStatement.setString(3, userPass);

            System.out.println(preparedStatement);

            preparedStatement.executeUpdate();

            AlertBox.display("user pwned", "ur signup successfully ");
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = HomePage.homeScene(stage);
            stage.setScene(scene);
        } catch (SQLException e) {

            printSQLException(e);
        }


    }


    public static void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }

    }
}