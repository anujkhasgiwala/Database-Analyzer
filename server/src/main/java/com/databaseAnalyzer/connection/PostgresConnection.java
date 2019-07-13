package com.databaseAnalyzer.connection;

import java.sql.*;
import java.util.*;

public class PostgresConnection extends AbstractDBConnection {
    public void connectDB(String hostUrl, String username, String password) {
        try {
            /*Properties properties = new Properties();
            properties.setProperty("ssl", "true");*/

            connection = DriverManager.getConnection(hostUrl, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<String> getDatabaseList() throws SQLException {
        List<String> databaseList = new ArrayList<>();

        ResultSet resultSet = connection.createStatement().executeQuery("select datname from pg_database where datistemplate = false;");

        while(resultSet.next()) {
            databaseList.add(resultSet.getString("datname"));
        }

        return databaseList;
    }
}
