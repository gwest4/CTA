package main;

import cta.TrackerCommunicator;

public class Main {

	public static void main(String[] args) {
		String response = TrackerCommunicator.sendQueryWithArgs(null);
		System.out.println(response);
	}

}
