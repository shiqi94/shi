package bean;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

/**
 * Created by Administrator on 2016/11/11 0011.
 */
public class Mong {
    private static MongoCollection coll;

    public static void connect() {
        MongoClient client = new MongoClient("localhost", 27017);
        MongoDatabase db = client.getDatabase("test");
        coll = db.getCollection("ceshi");
    }
}
