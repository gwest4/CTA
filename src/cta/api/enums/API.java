package cta.api.enums;

public enum API {
	FOLLOW		("http://lapi.transitchicago.com/api/1.0/ttfollow.aspx"),
	LOCATIONS	("http://lapi.transitchicago.com/api/1.0/ttpositions.aspx"),
	ARRIVALS	("http://lapi.transitchicago.com/api/1.0/ttarrivals.aspx");
	
	public final String baseURL;
	public final String key;
	API (String baseURL) {
		this.baseURL = baseURL;
		this.key = "5ae04ab42f7a408f9f1e9f7361273b68";
	}
}