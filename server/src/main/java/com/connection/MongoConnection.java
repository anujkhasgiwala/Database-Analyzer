package main.java.com.connection;

import com.mongodb.*;

import java.sql.SQLException;
import java.util.List;

public class MongoConnection extends AbstractDBConnection {
    public void connectDB(String hostUrl, String username, String password) {
        try
        {
            MongoCredential credential = MongoCredential.createCredential(username, "test", password.toCharArray());
            MongoClient mongoClient = new MongoClient(hostUrl, port);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<String> getDatabaseList() throws SQLException {
        return null;
    }
}
