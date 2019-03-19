package main.java.com.connection;

import java.sql.*;
import java.util.*;

public class MySQLConnection extends AbstractDBConnection {
    public void connectDB(String hostUrl, String username, String password) {
        try
        {
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
