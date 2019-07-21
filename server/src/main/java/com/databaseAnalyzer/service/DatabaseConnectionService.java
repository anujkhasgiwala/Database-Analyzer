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

	public List<String> getDatabaseList(String provider, String hostUrl, String username, String password) {
		dbConnection = DBConnectionSingletonFactory.getInstance(provider);
		
		try {
			dbConnection.connectDB(hostUrl, username, password);
			return dbConnection.getDatabaseList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ArrayList<String>();
	}
}
