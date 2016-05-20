package cta.api;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class APICommunicator {
	private final static String ARRIVALS_BASE_URL = "http://lapi.transitchicago.com/api/1.0/ttarrivals.aspx";
	private final static String USER_AGENT = "Mozilla/5.0";

	public static String sendGet(APIQueryBuilder b) {
		//HttpURLConnection connection = null;
		try {
			URL obj = new URL(ARRIVALS_BASE_URL + b.toQueryString());
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();

			// optional default is GET
			con.setRequestMethod("GET");

			//add request header
			con.setRequestProperty("User-Agent", USER_AGENT);

			int responseCode = con.getResponseCode();
			System.out.println("\nSending 'GET' request");
			System.out.println("Response Code : " + responseCode);

			BufferedReader in = new BufferedReader(
					new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			//print result
			return response.toString();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
