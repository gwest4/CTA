package cta.api;
import java.util.ArrayList;

import utils.TrainStop;
import utils.TrainStop.TrainLine;
import utils.TrainStopDataParser;

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
		this.redLineStops = getStopsForLine(TrainLine.RED_LINE);
		this.blueLineStops = getStopsForLine(TrainLine.BLUE_LINE);
		this.greenLineStops = getStopsForLine(TrainLine.GREEN_LINE);
		this.brownLineStops = getStopsForLine(TrainLine.BROWN_LINE);
		this.purpleLineStops = getStopsForLine(TrainLine.PURPLE_LINE);
		this.purpleExpressLineStops = getStopsForLine(TrainLine.PURPLE_EXPRESS_LINE);
		this.yellowLineStops = getStopsForLine(TrainLine.YELLOW_LINE);
		this.pinkLineStops = getStopsForLine(TrainLine.PINK_LINE);
		this.orangeLineStops = getStopsForLine(TrainLine.ORANGE_LINE);
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
	
	private ArrayList<TrainStop> getStopsForLine(TrainLine tl) {
		ArrayList<TrainStop> specifiedStops = new ArrayList<TrainStop>();
		for (TrainStop stop: allStops) {
			if (stop.trainLines.contains(tl)) specifiedStops.add(stop);
		}
		return specifiedStops;
	}
	
}
