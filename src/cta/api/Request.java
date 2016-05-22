package cta.api;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map.Entry;

public class Request {
	private final HashMap<String,String> params;
	private final String baseURL;
	
	public Request(String key, String baseURL) {
		this.baseURL = baseURL;
		this.params = new HashMap<String,String>();
		this.params.put("key", key);
	}
	
	public void addParameter(String p, String v) {
		params.put(p, v);
	}
	
	public void removeParameter(String p) {
		params.remove(p);
	}
	
	public URL url() {
		try {
			return new URL(this.toString());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public String toString() {
		String qs = this.baseURL + "?";
		int argsProcessed = 0;
		for (Entry<String,String> entry: params.entrySet()) {
			qs += entry.getKey() + "=" + entry.getValue();
			argsProcessed ++;
			if (argsProcessed < params.size()) {
				qs += "&";
			}
		}
		return qs;
	}
}