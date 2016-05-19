package utils;

import java.io.FileOutputStream;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class TrainStopDataManager {
	
	public static final String DATA_PATH = "data/cta_train_stops.csv";
	private static final String DOWNLOAD_URL = "https://data.cityofchicago.org/api/views/8pix-ypme/rows.csv?accessType=DOWNLOAD";
	
	public static void updateStopData() {
		
		try {
			URL url = new URL(DOWNLOAD_URL);
			ReadableByteChannel c = Channels.newChannel(url.openStream());
			FileOutputStream out = new FileOutputStream(DATA_PATH);
			Long bytes = out.getChannel().transferFrom(c, 0, Long.MAX_VALUE);
			out.close();
			System.out.println("Successfully updated file: \"" + DATA_PATH + "\" ("
					+bytes/1000.0+" KB)");
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	}
	
	public static void main(String[] args) {
		TrainStopDataManager.updateStopData();
	}
}