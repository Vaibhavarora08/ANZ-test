package com.example.simplerestapis.models;

public class PostRequest {
	long version;
        String lastcommitsha;
	String description;

	public long getversion() {
		return version;
	}

	public void setversion(long version) {
		this.version = version;
	}

	public String getlastcommitsha() {
		return lastcommitsha;
	}

	public void setlastcommiitsha(long lastcommitsha) {
		this.lastcommitsha = lastcommitsha;
	}
	
	public String getdescription() {
		return description;
	}

	public void setdescription(String description) {
		this.description = description;
	}

}


