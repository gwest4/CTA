package main;

import java.io.BufferedReader;

import cta.api.Request;
import cta.api.Response;
import cta.api.ArrivalsAPI;
import cta.api.LocationsAPI;

public class Main {
	
	public static void main(String[] args) {
		LocationsAPI locations = new LocationsAPI();
		Request req1 = locations.createRequest();
		Response res1 = locations.sendRequest(req1);
		
		/* Example usage
		
		Trains trains = res1.getTrains();
		
		*/
		
		
		ArrivalsAPI arrivals = new ArrivalsAPI();
		Request req2 = arrivals.createRequest();
		Response res2 = arrivals.sendRequest(req2);
	}

}
