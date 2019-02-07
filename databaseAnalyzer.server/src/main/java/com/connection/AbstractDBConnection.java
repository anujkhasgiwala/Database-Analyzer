package main.java.com.connection;

import java.sql.*;

public abstract class AbstractDBConnection {
    String hostUrl;
    int port;

    public Connection connection;
    Statement statement;

    public void extractDetails(String connection) {
       if (connection != null && !connection.isEmpty()) {
           hostUrl = connection.substring(0, connection.lastIndexOf(":"));
           port = Integer.parseInt(connection.substring(connection.lastIndexOf(":") + 1));
       }
    }

    abstract void connectDB(String hostUrl, String username, String password);
}
