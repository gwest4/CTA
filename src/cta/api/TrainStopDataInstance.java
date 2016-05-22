package cta.api;
import java.util.ArrayList;
import java.util.function.Predicate;

public class TrainStopDataInstance {
	// singleton instance
	public static TrainStopDataInstance instance = new TrainStopDataInstance();
	
	// fields initialized with singleton
	public ArrayList<TrainStop> allStops;
	
	
	private TrainStopDataInstance() {
		this.allStops = TrainStopDataParser.parse();
	}

	public static TrainStopDataInstance getInstance() {
		return instance;
	}
	
	public ArrayList<TrainStop> getAllStops() {
		return allStops;
	}
	
	public ArrayList<TrainStop> getTrainStopsWithPredicate(Predicate<TrainStop> test) {
		ArrayList<TrainStop> result = new ArrayList<TrainStop>();
		for (TrainStop s : allStops) {
			if (test.test(s)) { result.add(s); }
		}
		return result;
		
	}
	
}
