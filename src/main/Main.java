package main;

import cta.api.enums.APIQueryParameter;
import cta.api.APICommunicator;
import cta.api.APIQueryBuilder;

public class Main {

	public static void main(String[] args) {
		APIQueryBuilder b = new APIQueryBuilder("");
		b.addParameter(APIQueryParameter.STATION_ID, "");
		String r = APICommunicator.sendGet(b);
		System.out.println(r);
	}

}
