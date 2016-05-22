package main;

import java.io.BufferedReader;

import cta.api.APIQueryBuilder;
import cta.api.APIQueryBuilder.*;
import cta.utils.CTADataClient;

public class Main {
	
	public static void main(String[] args) {
		APIQueryBuilder b = new APIQueryBuilder(API.ARRIVALS);
		b.addParameter(QueryVariable.STOP_ID, "30117");
		BufferedReader responseReader = CTADataClient.sendAPIQuery(b);
	}

}
