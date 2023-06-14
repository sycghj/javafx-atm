package xyz.syc.atm.atm;

import java.sql.*;

public class Dao {
    static Connection conn = null;
    public static ResultSet queryInfo(String username){
        try {
            conn = GetConnection.getConnection();
            String sql = "SELECT * FROM user WHERE bankid=?";
            PreparedStatement preStmt = conn.prepareStatement(sql);
            preStmt.setString(1,username);
            return preStmt.executeQuery();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void updatePasswd(String passwd){
        try {
            conn = GetConnection.getConnection();
            String sql = "UPDATE `user` SET `passwd` = ? WHERE `bankid` = ?";
            PreparedStatement preStmt = conn.prepareStatement(sql);
            preStmt.setString(1,passwd);
            preStmt.setString(2,DataModel.getNum());
            preStmt.executeUpdate();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void updateMoney(int money){
        try {
            conn = GetConnection.getConnection();
            String sql = "UPDATE `user` SET `money` = money+? WHERE `bankid` = ?";
            PreparedStatement preStmt = conn.prepareStatement(sql);
            preStmt.setInt(1,money);
            preStmt.setString(2,DataModel.getNum());
            preStmt.executeUpdate();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
