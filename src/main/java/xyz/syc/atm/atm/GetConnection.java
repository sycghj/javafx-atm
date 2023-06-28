package xyz.syc.atm.atm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GetConnection {
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://127.0.0.1:3306/bank";
        String userName = "root";
        String passwd = "204893";
        return DriverManager.getConnection(url, userName, passwd);
    }
}
