package com.databaseAnalyzer.connection;

import org.springframework.beans.factory.annotation.Autowired;

public class DBConnectionSingletonFactory {
	@Autowired
	private static AbstractDBConnection dbConnectionPostgres;

	private DBConnectionSingletonFactory(String type) {
		switch (type) {
		case "Postgres":
			dbConnectionPostgres = new PostgresConnection();
			break;
		/*
		 * case "MySQL": dbConnection = new MySQLConnection(); break; case "Mongo":
		 * dbConnection = new MongoConnection(); break;
		 */
		}
	}
	
	public static AbstractDBConnection getInstance(String type) {
		switch (type) {
		case "Postgres":
			if(dbConnectionPostgres == null)
				new DBConnectionSingletonFactory(type);
			return dbConnectionPostgres;
		}
		
		return null;
	}
}
