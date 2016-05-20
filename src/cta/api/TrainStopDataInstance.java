package cta.api;
import java.util.ArrayList;

import utils.TrainStop;
import utils.TrainStopDataParser;

public class TrainStopDataInstance {
	public static TrainStopDataInstance instance = new TrainStopDataInstance();
	public static ArrayList<TrainStop> allTrainStops;
	
	private TrainStopDataInstance() {
		this.allTrainStops = TrainStopDataParser.parse();
	}
	
	public static TrainStopDataInstance getInstance() {
		return instance;
	}
	
	public ArrayList<TrainStop> getAllTrainStops() {
		return allTrainStops;
	}
	
}
