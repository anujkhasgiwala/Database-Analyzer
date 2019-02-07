package main.java.com.service;

import main.java.com.connection.AbstractDBConnection;
import main.java.com.connection.MongoConnection;
import main.java.com.connection.MySQLConnection;
import main.java.com.connection.PostgresConnection;

import java.sql.*;
import java.util.*;

public class DatabaseConnectionService {
    AbstractDBConnection dbConnection;

    public List<String> getDatabaseList(String provider, String hostUrl) {
        List<String> databaseList = new ArrayList<String>();
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
            ResultSet resultset = dbConnection.connection.createStatement().executeQuery("show databases;");

            //databaseList.addAll(dbConnection.connection.getMetaData().getCatalogs());
        } catch (Exception e) {

        }
        return null;
    }
}
