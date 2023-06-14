module xyz.syc.atm.atm {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.jfoenix;
    requires mysql.connector.j;
    requires java.sql;

    opens xyz.syc.atm.atm to javafx.fxml;
    exports xyz.syc.atm.atm;
}