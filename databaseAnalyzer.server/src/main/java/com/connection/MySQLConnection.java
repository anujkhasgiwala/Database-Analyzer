package main.java.com.connection;

import java.sql.*;

public class MySQLConnection extends AbstractDBConnection {
    void connectDB(String hostUrl, String username, String password) {
        try
        {
            connection = DriverManager.getConnection(hostUrl, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
