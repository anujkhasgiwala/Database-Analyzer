package com.databaseAnalyzer.service;

import java.util.ArrayList;
import java.util.List;

import com.databaseAnalyzer.connection.AbstractDBConnection;
import com.databaseAnalyzer.connection.MongoConnection;
import com.databaseAnalyzer.connection.MySQLConnection;
import com.databaseAnalyzer.connection.PostgresConnection;

public class DatabaseConnectionService {
    AbstractDBConnection dbConnection;

    public List<String> getDatabaseList(String provider, String hostUrl, String username, String password) {
        switch (provider) {
            case "Postgres":
                dbConnection = new PostgresConnection();
                break;
            case "MySQL":
                dbConnection = new MySQLConnection();
                break;
            case "Mongo":
                dbConnection = new MongoConnection();
                break;
        }

        try {
            dbConnection.connectDB(hostUrl, username, password);
            return dbConnection.getDatabaseList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<String>();
    }
}
