package cta.api;

public class Location {
	public final double latitude;
	public final double longitude;

	Location(double latitude, double longitude) {
		this.latitude = latitude;
		this.longitude = longitude;

	}

	public String toString() {
		return "(" + latitude + ", " + longitude + ")";
	}
}