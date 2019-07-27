package com.databaseAnalyzer.connection;

//import com.mongodb.*;

import java.sql.SQLException;
import java.util.List;

public class MongoConnection extends AbstractDBConnection {
    public void connectDB(String hostUrl, String username, String password) {
        try
        {
			/*
			 * MongoCredential credential = MongoCredential.createCredential(username,
			 * "test", password.toCharArray()); MongoClient mongoClient = new
			 * MongoClient(hostUrl, port);
			 */
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<String> getDatabaseList() throws SQLException {
        return null;
    }

	@Override
	public List<String> getTableList(String schemaName) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
}
