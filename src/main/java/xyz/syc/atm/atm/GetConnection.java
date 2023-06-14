package xyz.syc.atm.atm;

import java.sql.*;

public class GetConnection {
     public static Connection getConnection() throws ClassNotFoundException, SQLException {
         Class.forName("com.mysql.cj.jdbc.Driver");
         String url = "jdbc:mysql://127.0.0.1:3306/bank";
         String userName = "root";
         String passwd = "passwd";
         return DriverManager.getConnection(url,userName,passwd);
     }
}
