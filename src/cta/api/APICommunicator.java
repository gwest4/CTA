package cta.api;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class APICommunicator {
	//private static final String USER_AGENT = "Mozilla/5.0";
	public static final String FILE_PATH = "data/xml/api_call_" + nextFileNumber() + ".xml";

	public static String sendGet(APIQueryBuilder b) {
		//HttpURLConnection connection = null;
		try {
			URL url = new URL(b.api.baseURL + b.toQueryString());
			/*
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			
			// optional default is GET
			con.setRequestMethod("GET");

			//add request header
			con.setRequestProperty("User-Agent", USER_AGENT);
			
			BufferedReader in = new BufferedReader(
					new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			*/
			
			ReadableByteChannel c = Channels.newChannel(url.openStream());
			FileOutputStream out = new FileOutputStream(FILE_PATH);
			Long bytes = out.getChannel().transferFrom(c, 0, Long.MAX_VALUE);
			out.close();
			System.out.println("Successfully updated file: \"" + FILE_PATH + "\" ("
					+bytes/1000.0+" KB)");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private static int file = 0;
	private static int nextFileNumber() {
		file++;
		return file;
		
	}

}
