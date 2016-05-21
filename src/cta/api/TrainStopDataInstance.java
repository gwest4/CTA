package cta.api;
import java.util.ArrayList;
import java.util.function.Predicate;

import cta.api.enums.TrainRoute;

public class TrainStopDataInstance {
	// singleton instance
	public static TrainStopDataInstance instance = new TrainStopDataInstance();
	
	// fields initialized with singleton
	public ArrayList<TrainStop> allStops;
	public ArrayList<TrainStop> redLineStops;
	public ArrayList<TrainStop>	blueLineStops;
	public ArrayList<TrainStop>	greenLineStops;
	public ArrayList<TrainStop>	brownLineStops;
	public ArrayList<TrainStop>	purpleLineStops;
	public ArrayList<TrainStop>	purpleExpressLineStops;
	public ArrayList<TrainStop>	yellowLineStops;
	public ArrayList<TrainStop>	pinkLineStops;
	public ArrayList<TrainStop>	orangeLineStops;
	
	
	private TrainStopDataInstance() {
		this.allStops = TrainStopDataParser.parse();
		this.redLineStops = getStopsForRoute(TrainRoute.RED_LINE);
		this.blueLineStops = getStopsForRoute(TrainRoute.BLUE_LINE);
		this.greenLineStops = getStopsForRoute(TrainRoute.GREEN_LINE);
		this.brownLineStops = getStopsForRoute(TrainRoute.BROWN_LINE);
		this.purpleLineStops = getStopsForRoute(TrainRoute.PURPLE_LINE);
		this.purpleExpressLineStops = getStopsForRoute(TrainRoute.PURPLE_EXPRESS_LINE);
		this.yellowLineStops = getStopsForRoute(TrainRoute.YELLOW_LINE);
		this.pinkLineStops = getStopsForRoute(TrainRoute.PINK_LINE);
		this.orangeLineStops = getStopsForRoute(TrainRoute.ORANGE_LINE);
	}

	public static TrainStopDataInstance getInstance() {
		return instance;
	}
	
	public ArrayList<TrainStop> getAllStops() {
		return allStops;
	}

	public ArrayList<TrainStop> getRedLineStops() {
		return redLineStops;
	}

	public ArrayList<TrainStop> getBlueLineStops() {
		return blueLineStops;
	}

	public ArrayList<TrainStop> getGreenLineStops() {
		return greenLineStops;
	}

	public ArrayList<TrainStop> getBrownLineStops() {
		return brownLineStops;
	}

	public ArrayList<TrainStop> getPurpleLineStops() {
		return purpleLineStops;
	}

	public ArrayList<TrainStop> getPurpleExpressLineStops() {
		return purpleExpressLineStops;
	}

	public ArrayList<TrainStop> getYellowLineStops() {
		return yellowLineStops;
	}

	public ArrayList<TrainStop> getPinkLineStops() {
		return pinkLineStops;
	}

	public ArrayList<TrainStop> getOrangeLineStops() {
		return orangeLineStops;
	}
	
	public ArrayList<TrainStop> getStopsWithPredicate(Predicate<TrainStop> test) {
		ArrayList<TrainStop> result = new ArrayList<TrainStop>();
		for (TrainStop s : allStops) {
			if (test.test(s)) { result.add(s); }
		}
		return result;
		
	}
	
	private ArrayList<TrainStop> getStopsForRoute(TrainRoute tl) {
		ArrayList<TrainStop> specifiedStops = new ArrayList<TrainStop>();
		for (TrainStop stop: allStops) {
			if (stop.trainLines.contains(tl)) specifiedStops.add(stop);
		}
		return specifiedStops;
	}
	
}
