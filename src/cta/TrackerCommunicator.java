package cta;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

public final class TrackerCommunicator {
	private final static String ARRIVALS_BASE_URL = "http://lapi.transitchicago.com/api/1.0/ttarrivals.aspx";
	
	public static String sendQueryWithArgs(HashMap<String,String> args) {
		if (args == null) return null;
		return sendQuery( formHtmlQuery(args) );
	}
	
	private static String formHtmlQuery (HashMap<String,String> args) {
		
		return null;
	}
	
	private static String sendQuery(String query) {
		HttpURLConnection connection = null;
		try {
			URL url = new URL(ARRIVALS_BASE_URL + query);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
