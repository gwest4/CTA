package cta.api;

import java.util.ArrayList;

import cta.api.enums.Direction;
import cta.api.enums.TrainRoute;

public class TrainStop {
	public final String stopId;
	public final Direction dir;
	public final String stopName;
	public final String stationName;
	public final String stationDescriptiveName;
	public final String stationId;
	public final boolean handicapAccessable;
	public final ArrayList<TrainRoute> trainLines;
	public final Location location;

	TrainStop (String stopId, Direction dir, String stopName, String stationName, String stationDescriptiveName,
			String stationId, boolean handicapAccessable, ArrayList<TrainRoute> trainLines, Location location) {
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

}
