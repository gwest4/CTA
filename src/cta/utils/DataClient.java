package cta.utils;

import java.io.FileOutputStream;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.io.File;

public class DataClient {
	
	public static final String API_CALL_LP = "data/api_response.xml";
	public static final String TRAIN_STOP_LP = "data/cta_train_stops.csv";
	private static final String TRAIN_STOP_URL = "https://data.cityofchicago.org/api/views/8pix-ypme/rows.csv?accessType=DOWNLOAD";
	
	
	public static File trainStopDataReader() {
		
		try {
			
			URL url = new URL(TRAIN_STOP_URL);
			return getFileFromURL(url, TRAIN_STOP_LP);
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return null;
		
	}
	
	
	public static File sendAPIQuery(URL url) {
		try {			
			return getFileFromURL(url, API_CALL_LP);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	private static File getFileFromURL(URL url, String local_path) {
		
		try {
			
			System.out.println("Transfer from \""+ url.toString() +"\"...");
			
			long transferStart = System.currentTimeMillis();
			ReadableByteChannel channel = Channels.newChannel(url.openStream());
			FileOutputStream out = new FileOutputStream(local_path); // Define output path
			
			Long bytes = out.getChannel().transferFrom(channel, 0, Long.MAX_VALUE); // Transfer bytes
			out.close();
			
			long transferEnd = System.currentTimeMillis();
			System.out.println("\t\"" + local_path + "\" (" +bytes/1000.0+" KB, "+ (transferEnd - transferStart) +" ms )");
			
			return new File( local_path );
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return null;
		
	}
	
	
	public static void main(String[] args) {
		DataClient.trainStopDataReader();
	}
}
