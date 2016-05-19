package main;

import cta.api.enums.Parameter;
import cta.api.TrackerCommunicator;
import cta.api.TrackerQueryBuilder;

public class Main {

	public static void main(String[] args) {
		TrackerQueryBuilder b = new TrackerQueryBuilder("");
		b.addParameter(Parameter.STATION_ID, "");
		String r = TrackerCommunicator.sendGet(b);
		System.out.println(r);
	}

}
