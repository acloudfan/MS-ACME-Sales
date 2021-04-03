package com.acme.db.util.mongodb;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public abstract class MongoDBBase {

    final public static String MONGODB_CLUSTER_URL="mongodb+srv://admin:s1knM3ZlMEGlsL2y@acmetravel.46e5h.mongodb.net/<dbname>?retryWrites=true&w=majority";
    final public static String DATABASE_NAME="ACMETravels";
    final public static String PROPOSOAL_COLLECTION="proposals";

    protected void execute(){
        MongoClient mongoClient = new MongoClient(new MongoClientURI(MONGODB_CLUSTER_URL));

        MongoDatabase database = mongoClient.getDatabase(DATABASE_NAME);

        MongoCollection collection = database.getCollection(PROPOSOAL_COLLECTION);

        Document document = Document.parse("{a:1, b:'raju'}");

        collection.insertOne(document);
    }

}
