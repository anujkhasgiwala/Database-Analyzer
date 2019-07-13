package com.databaseAnalyzer.connection;

import java.sql.*;
import java.util.*;

public abstract class AbstractDBConnection {
    String hostUrl;
    int port;

    public Connection connection;
    Statement statement;

    public void extractDetails(String connection) {
       /*if (connection != null && !connection.isEmpty()) {
           hostUrl = connection.substring(0, connection.lastIndexOf(":"));
           port = Integer.parseInt(connection.substring(connection.lastIndexOf(":") + 1));
       }*/
    }

    public abstract void connectDB(String hostUrl, String username, String password);

    public abstract List<String> getDatabaseList() throws SQLException;
}
