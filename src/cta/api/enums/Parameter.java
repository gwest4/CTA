package cta.api.enums;

public enum Parameter {
	STOP_ID			("stpid"),
	STATION_ID		("mapid"),
	MAXIMUM_RESULTS	("max"),
	ROUTE_CODE		("rt");
	
	public final String urlParameterString;
	Parameter (String urlParameterString) {
        this.urlParameterString = urlParameterString;
    }
}
