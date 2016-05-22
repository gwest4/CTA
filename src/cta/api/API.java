package cta.api;

public interface API {
	public static final String API_KEY = cta.config.Configuration.API_KEY;
	
	abstract Response sendRequest (Request q);
	
	public Request createRequest();
	
}
