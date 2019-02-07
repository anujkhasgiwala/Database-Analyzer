package main.java.com.connection;

import java.sql.*;
import java.util.*;

public class PostgresConnection extends AbstractDBConnection {
    void connectDB(String hostUrl, String username, String password) {
        try {
            /*Properties properties = new Properties();
            properties.setProperty("user", username);
            properties.setProperty("password", password);
            properties.setProperty("ssl", "true");*/

            connection = DriverManager.getConnection(hostUrl, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
