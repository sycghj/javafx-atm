module xyz.syc.atm.atm {
    requires javafx.controls;
    requires javafx.fxml;
    requires mysql.connector.j;
    requires java.sql;
    requires com.jfoenix;
    requires org.controlsfx.controls;

    opens xyz.syc.atm.atm to javafx.fxml;
    exports xyz.syc.atm.atm;
}