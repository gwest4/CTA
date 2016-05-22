package cta.utils;

import java.io.FileOutputStream;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.io.BufferedReader;
import java.io.FileReader;

public class DataClient {
	
	public static final String TRAIN_STOP_LP = "data/cta_train_stops.csv";
	private static final String TRAIN_STOP_URL = "https://data.cityofchicago.org/api/views/8pix-ypme/rows.csv?accessType=DOWNLOAD";
	
	public static BufferedReader trainStopDataReader() {
		try {
			URL url = new URL(TRAIN_STOP_URL);
			
			return getFileFromURL(url, TRAIN_STOP_LP);
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return null;
	}
	
	public static BufferedReader sendAPIQuery(URL url) {
		try {			
			return getFileFromURL(url, API_CALL_LP);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private static BufferedReader getFileFromURL(URL url, String local_path) {
		try {
			System.out.println("Transfer from \""+ url.toString() +"\"...");
			long transferStart = System.currentTimeMillis();
			ReadableByteChannel c = Channels.newChannel(url.openStream());
			FileOutputStream out = new FileOutputStream(local_path);
			Long bytes = out.getChannel().transferFrom(c, 0, Long.MAX_VALUE);
			out.close();
			long transferEnd = System.currentTimeMillis();
			System.out.println("\t\"" + local_path + "\" (" +bytes/1000.0+" KB, "+ (transferEnd - transferStart) +" ms )");
			
			
			return new BufferedReader( new FileReader( local_path ));
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return null;
		
	}
	
	public static void main(String[] args) {
		DataClient.trainStopDataReader();
	}
}
