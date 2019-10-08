package com.databaseAnalyzer.connection;

import java.sql.*;
import java.util.*;

public class PostgresConnection extends AbstractDBConnection {
	private static Connection connection;
	
    public void connectDB(String hostUrl, String username, String password) {
        try {
            Class.forName("org.postgresql.Driver");
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
    
    public List<String> getTableList(String schemaName) throws SQLException {
        List<String> tableList = new ArrayList<>();

        ResultSet resultSet = connection.createStatement().executeQuery("select tablename FROM pg_catalog.pg_tables WHERE schemaname = '" + schemaName + "';");

        while(resultSet.next()) {
            tableList.add(resultSet.getString("tablename"));
        }

        return tableList;
    }
}
