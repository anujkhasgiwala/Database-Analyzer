package com.databaseAnalyzer.connection;

import java.sql.SQLException;
import java.util.List;

public abstract class AbstractDBConnection {
    public abstract void connectDB(String hostUrl, String username, String password);

    public abstract List<String> getDatabaseList() throws SQLException;
    
    public abstract List<String> getTableList(String schemaName) throws SQLException;
}
