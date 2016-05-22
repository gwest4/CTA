package cta.api;

import java.io.BufferedReader;
import java.util.HashMap;
import java.util.Map.Entry;

public abstract class API {
	public String baseURL;
	public String key;
	
	abstract BufferedReader sendQuery (QueryBuilder q);
	
	public QueryBuilder newQuery(key);
	
	abstract public class QueryBuilder {
		public final HashMap<String,String> params;
		
		public QueryBuilder(String key) {
			this.params = new HashMap<String,String>();
			this.params.put("key", key);
		}
		
		abstract public void addParameter(String p, String v) {
			queryParams.put(p.variableName, v);
		}
		
		public void removeParameter(QueryVariable p) {
			queryParams.remove(p.variableName);
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
	
}
