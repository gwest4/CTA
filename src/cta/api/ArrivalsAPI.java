package cta.api;

public class ArrivalsAPI implements API {
	private static final String BASE_URL = "http://lapi.transitchicago.com/api/1.0/ttarrivals.aspx";

	@Override
	public Response sendRequest(Request q) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Request createRequest() {
		return new Request(API_KEY, BASE_URL);
		
	}

}
