package main.java.com.connection;

import com.mongodb.*;

public class MongoConnection extends AbstractDBConnection {
    void connectDB(String hostUrl, String username, String password) {
        try
        {
            MongoCredential credential = MongoCredential.createCredential(username, "test", password.toCharArray());
            MongoClient mongoClient = new MongoClient(hostUrl, port);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
