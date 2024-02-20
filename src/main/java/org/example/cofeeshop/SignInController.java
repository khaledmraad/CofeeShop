package org.example.cofeeshop;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

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


    @FXML
    protected void signIn() {
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

            }
            else {
                AlertBox.display("XD", "u dont exist");

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

}