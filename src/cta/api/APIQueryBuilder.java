package cta.api;

import java.util.HashMap;
import java.util.Map.Entry;

public class APIQueryBuilder {
	private final HashMap<String,String> queryParams;
	/**
	 * URL Parameters to be used with the CTA Arrivals API
	 * 
	 * @param STOP_ID - A single five-digit code to tell the server which specific stop (in this context, specific platform or platform side within a larger station) you’d like to receive predictions for. See appendix for information about valid stop codes.
	 * @param STATION_ID - A single five-digit code to tell the server which station you’d like to receive predictions for. See appendix for information about valid station codes.
	 * @param MAXIMUM_RESULTS - The maximum number you’d like to receive (if not specified, all available results for the requested stop or station will be returned)
	 * @param ROUTE_CODE - Allows you to specify a single route for which you’d like results (if not specified, all available results for the requested stop or station will be returned)
	 * @author George
	 */
	
	public APIQueryBuilder(String apiKey) {
		this.queryParams = new HashMap<String,String>();
		this.queryParams.put("key", apiKey);
	}
	
	public void addParameter(APIQueryParameter p, String v) {
		queryParams.put(p.urlParameterString, v);
	}
	
	public void removeParameter(APIQueryParameter p) {
		queryParams.remove(p.urlParameterString);
	}
	
	public String toQueryString() {
		String qs = "?";
		int argsProcessed = 0;
		for (Entry<String,String> entry: queryParams.entrySet()) {
			qs += entry.getKey() + "=" + entry.getValue();
			argsProcessed ++;
			if (argsProcessed < queryParams.size()) {
				qs += "&";
			}
		}
		return qs;
	}
}
