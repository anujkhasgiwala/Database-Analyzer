package com.databaseAnalyzer.connection;

import java.sql.*;
import java.util.*;

public class MySQLConnection extends AbstractDBConnection {
    public void connectDB(String hostUrl, String username, String password) {
        
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
