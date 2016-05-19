package cta.api.enums;

public enum APIQueryParameter {
	STOP_ID			("stpid"),
	STATION_ID		("mapid"),
	MAXIMUM_RESULTS	("max"),
	ROUTE_CODE		("rt");
	
	public final String urlParameterString;
	APIQueryParameter (String urlParameterString) {
        this.urlParameterString = urlParameterString;
    }
}
