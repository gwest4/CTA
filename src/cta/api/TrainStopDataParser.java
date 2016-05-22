package cta.api;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import cta.utils.CTADataClient;


public class TrainStopDataParser {

	public static void main(String[] args) {
		System.out.print(TrainStopDataParser.parse());

	}
	
	public static ArrayList<TrainStop> parse() {
		ArrayList<TrainStop> trainStops = new ArrayList<TrainStop>();
		BufferedReader br = null;
		String csvLine = "";

		try {
			br = CTADataClient.getTrainStopDataFile();
			
			br.readLine(); // skip header line
			
			while ((csvLine = br.readLine()) != null) {
				String[] csvRow = parseLine(csvLine);
				
				String stopId = csvRow[0];
				
				Direction dir = null;
				switch (csvRow[1]) {
					case "N": 	dir = Direction.NORTH; 	break;
					case "S": 	dir = Direction.SOUTH; 	break;
					case "E": 	dir = Direction.EAST;	break;
					case "W": 	dir = Direction.WEST;	break;
					default:	System.out.println("Invalid direction");
				}
				
				String stopName = csvRow[2];
				
				String stationName = csvRow[3];
				
				String stationDescriptiveName = csvRow[4];
				
				String stationId = csvRow[5];
				
				boolean handicapAccessable = csvRow[6].equalsIgnoreCase("true") ? true : false;
				
				ArrayList<TrainRoute> trainLines = new ArrayList<TrainRoute>();
				if (csvRow[7].equalsIgnoreCase("true")) { trainLines.add(TrainRoute.RED_LINE); }
				if (csvRow[8].equalsIgnoreCase("true")) { trainLines.add(TrainRoute.BLUE_LINE); }
				if (csvRow[9].equalsIgnoreCase("true")) { trainLines.add(TrainRoute.GREEN_LINE); }
				if (csvRow[10].equalsIgnoreCase("true")) { trainLines.add(TrainRoute.BROWN_LINE); }
				if (csvRow[11].equalsIgnoreCase("true")) { trainLines.add(TrainRoute.PURPLE_LINE); }
				if (csvRow[12].equalsIgnoreCase("true")) { trainLines.add(TrainRoute.PURPLE_EXPRESS_LINE); }
				if (csvRow[13].equalsIgnoreCase("true")) { trainLines.add(TrainRoute.YELLOW_LINE); }
				if (csvRow[14].equalsIgnoreCase("true")) { trainLines.add(TrainRoute.PINK_LINE); }
				if (csvRow[15].equalsIgnoreCase("true")) { trainLines.add(TrainRoute.ORANGE_LINE); }
				
				String[] loc = csvRow[16].substring(2, csvRow[16].length()-2).split(",");
				Location location = new Location(Double.valueOf(loc[0]), Double.valueOf(loc[1]));
				
				TrainStop stop = new TrainStop(stopId, dir, stopName, stationName, stationDescriptiveName, stationId, handicapAccessable, trainLines, location);
				trainStops.add(stop);
			}
			
			return trainStops;
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			
		} catch (IOException e) {
			e.printStackTrace();
			
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}
	
	private static String[] parseLine(String csvLine) {
		String[] strings = new String[17]; // array to which each string will be parsed out to
		boolean insideQuotes = false; // state of current index
		
		int copyStart = 0; 	// beginning index of the string to be copied
		int copyEnd = 0;	// end index of string to be copied (not inclusive)
		int copyTo = 0;		// destination index within "strings" array
		
		for (int i=0; i<csvLine.length(); i++) {
			char c = csvLine.charAt(i);
			
			if (c=='"') { insideQuotes = !insideQuotes; } // change state
			/*
			 * copies string to array when comma is reached, but only if not inside " "
			 * this allows CSVs to contain attributes with commas, escaped using quotes
			 * 		example:	attribute,attribute,"attrbute,with,commas",attribute
			 */
			if (c==',' && !insideQuotes) {
				copyEnd = i;
				strings[copyTo] = csvLine.substring(copyStart, copyEnd);
				copyTo++;
				copyStart = i+1;
			}
		}
		strings[copyTo] = csvLine.substring(copyStart, csvLine.length());
		
		return strings;
	}

}