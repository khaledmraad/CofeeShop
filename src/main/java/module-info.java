module org.example.cofeeshop {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens org.example.cofeeshop to javafx.fxml;
    exports org.example.cofeeshop;
}