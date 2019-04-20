package main.java.com.service;

import java.util.ArrayList;
import java.util.List;

import main.java.com.connection.AbstractDBConnection;
import main.java.com.connection.MongoConnection;
import main.java.com.connection.MySQLConnection;
import main.java.com.connection.PostgresConnection;

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
