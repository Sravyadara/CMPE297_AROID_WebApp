package controllers;

import java.util.Arrays;

import com.mongodb.*;

import play.Configuration;
import uk.co.panaxiom.playjongo.*;

public class MyMongoClientFactory extends MongoClientFactory{
	private Configuration config;
	public MyMongoClientFactory(Configuration config) {
		super(config);
		this.config = config;
	}
	
	public MongoClient createClient() throws Exception{
		MongoClientOptions options = MongoClientOptions.builder()
				.connectionsPerHost(100)
				.maxConnectionIdleTime(6000)
				.build();
		
		return new MongoClient(Arrays.asList(new ServerAddress("127.0.0.1", 27017)), options);
	}

}
