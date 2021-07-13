package com.rakuten.training.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;
import org.springframework.data.couchbase.repository.config.EnableCouchbaseRepositories;

@Configuration

public class CouchConfig extends AbstractCouchbaseConfiguration{

	@Override
	public String getConnectionString() {
		// TODO Auto-generated method stub
		return "couchbase://127.0.0.1";
	}

	@Override
	public String getUserName() {
		// TODO Auto-generated method stub
		return "Parth";
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return "rakuten";
	}

	@Override
	public String getBucketName() {
		// TODO Auto-generated method stub
		return "training";
	}

	
}
