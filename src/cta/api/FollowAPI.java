package cta.api;

public class FollowAPI implements API {
	private static final String BASE_URL = "lapi.transitchicago.com/api/1.0/ttfollow.aspx";

	@Override
	public Response sendRequest(Request q) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Request createRequest() {
		return new Request(API_KEY, BASE_URL);

	}
	
	public enum Param {
		RUN_NUMBER ("runnumber");
		
		private final String name; // parameter name to be used in request URL
	    Param(String name) {
	    	this.name = name;
	    }
	}

}
