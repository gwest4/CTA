package main;

import cta.api.APICommunicator;
import cta.api.APIQueryBuilder;
import cta.api.enums.API;
import cta.api.enums.APIQueryParameter;

public class Main {
	public static void main(String[] args) {
		APIQueryBuilder b = new APIQueryBuilder(API.ARRIVALS);
		b.addParameter(APIQueryParameter.STOP_ID, "30117");
		String r = APICommunicator.sendGet(b);
		System.out.println(r);
	}

}
