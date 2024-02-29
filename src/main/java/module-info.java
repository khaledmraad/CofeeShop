module org.cofeeshop {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires jakarta.persistence;
    requires org.hibernate.orm.core;
    requires java.naming;


    opens org.example.cofeeshop to javafx.fxml;
    exports org.example.cofeeshop;
}