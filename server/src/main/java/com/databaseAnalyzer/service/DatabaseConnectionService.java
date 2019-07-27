package com.databaseAnalyzer.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.databaseAnalyzer.connection.AbstractDBConnection;
import com.databaseAnalyzer.connection.DBConnectionSingletonFactory;

@Service
public class DatabaseConnectionService {
	private AbstractDBConnection dbConnection;
	private String hostUrl, username, password;

	public List<String> getDatabaseList(String provider, String hostUrl, String username, String password) {
		dbConnection = DBConnectionSingletonFactory.getInstance(provider);
		
		if(hostUrl.matches("^https?://"))
			this.hostUrl = "jdbc:postgresql://" + hostUrl.split("://")[1] + "/postgres";
		else
			this.hostUrl = "jdbc:postgresql://" + hostUrl + "/postgres";
		this.username = username;
		this.password = password;
		
		try {
			dbConnection.connectDB(this.hostUrl, username, password);
			return dbConnection.getDatabaseList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ArrayList<String>();
	}
	
	public List<String> getTableList(String databaseName, String schemaName) {
		try {
			int lastIndex = this.hostUrl.lastIndexOf("/");
			this.hostUrl = this.hostUrl.substring(0,lastIndex+1) + databaseName;
			dbConnection.connectDB(this.hostUrl, this.username, this.password);
			return dbConnection.getTableList(schemaName);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return new ArrayList<String>();
	}
}
