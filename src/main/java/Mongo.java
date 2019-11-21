


import java.net.UnknownHostException;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.MongoClient;

import org.bson.Document;
import com.google.gson.Gson;


public class Mongo {


	private MongoDatabase database;
	private MongoCollection<Document> collection;

	final Gson gson = new Gson();



	public void setMongo() {

		MongoClient mongoClient = null;
		mongoClient = new MongoClient("localhost", 27017);
		database = mongoClient.getDatabase("MovieDB");
		collection = database.getCollection("Movie");
	}

	public void insertMovies(List<Movie> l) {
		for (Movie m: l) {
			insertMovie(m);
		}
	}

	public void insertMovie(Movie m) {
		Document doc = Document.parse(gson.toJson(m));
		collection.insertOne(doc);
	}

	public Movie getMovie(String title) {
		Document doc = collection.find(Filters.eq("title", title)).first();
		Movie m = gson.fromJson(doc.toJson(), Movie.class);
		return m;
	}

	public void deleteMovie(String title) {
		collection.deleteOne(Filters.eq("title", title));
	}

	public Map<String, Object> getAll() {
		Map<String, Object> hm = new HashMap<>();
		FindIterable<Document> docs = collection.find();
		for (Document doc: docs) {
			Movie m = gson.fromJson(doc.toJson(), Movie.class);
			hm.put(m.getTitle(), m);
		}
		return hm;
	}

}