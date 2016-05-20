package utils;

import java.util.ArrayList;

public class TrainStop {
	public final String stopId;
	public final Direction dir;
	public final String stopName;
	public final String stationName;
	public final String stationDescriptiveName;
	public final String stationId;
	public final boolean handicapAccessable;
	public final ArrayList<TrainLine> trainLines;
	public final Location location;

	TrainStop (String stopId, Direction dir, String stopName, String stationName, String stationDescriptiveName,
			String stationId, boolean handicapAccessable, ArrayList<TrainLine> trainLines, Location location) {
		this.stopId = stopId;
		this.dir = dir;
		this.stopName = stopName;
		this.stationName = stationName;
		this.stationDescriptiveName = stationDescriptiveName;
		this.stationId = stationId;
		this.handicapAccessable = handicapAccessable;
		this.trainLines = trainLines;
		this.location = location;
	}
	
	public String toString() {
		return "\nTrainStop@"+Integer.toHexString(this.hashCode())+"\n"+
				"\tstopId: "+this.stopId+"\n"+
				"\tdir: "+this.dir+"\n"+
				"\tstopName: "+this.stopName+"\n"+
				"\tstationName: "+this.stationName+"\n"+
				"\tstationDescriptiveName: "+this.stationDescriptiveName+"\n"+
				"\tstationId: "+this.stationId+"\n"+
				"\thandicapAccessable: "+this.handicapAccessable+"\n"+
				"\ttrainLines: "+this.trainLines+"\n"+
				"\tlocation: "+this.location;
	}
	
	public enum Direction {
		NORTH,
		SOUTH,
		EAST,
		WEST,
		NONE;
	}

	public enum TrainLine {
		RED_LINE,
		BLUE_LINE,
		GREEN_LINE,
		BROWN_LINE,
		PURPLE_LINE,
		PURPLE_EXPRESS_LINE,
		YELLOW_LINE,
		PINK_LINE,
		ORANGE_LINE;
	}

}
