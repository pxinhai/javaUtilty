package baseportal.util;

public class DegreeModel {

	private double lat;
	private double lng;

	public DegreeModel() {
	}

	public DegreeModel(double lat, double lng) {
		this.lat = lat;
		this.lng = lng;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLng() {
		return lng;
	}

	public void setLng(double lng) {
		this.lng = lng;
	}

	private final double EARTH_RADIUS = 6378137;// 地球半径(米)

	private static double radians(double d) {
		return d * Math.PI / 180;
	}


	public double calculateDistance(double lat, double lng) {
		double radLat1 = radians(this.lat);
		double radLat2 = radians(lat);
		double a = radLat1 - radLat2;
		double b = radians(this.lng) - radians(lng);
		double s = 2 * Math.asin(
				Math.sqrt(
				Math.pow(Math.sin(a / 2), 2) + Math.cos(radLat1) * Math.cos(radLat2) * Math.pow(Math.sin(b / 2), 2)
						)
								);
		s = s * EARTH_RADIUS;
		return Math.round(s);
	}

	public double calculateDistanceGoogle(double lat, double lng) {
		double radLat1 = radians(this.lat);
		double radLng1 = radians(this.lng);
		
		double radLat2 = radians(lat);
		double radLng2 = radians(lng);

		double s = Math.acos(Math.cos(radLat1) * Math.cos(radLat2) * Math.cos(radLng1 - radLng2)
				+ Math.sin(radLat1) * Math.sin(radLat2));
		s = s * EARTH_RADIUS;
		return Math.round(s);
	}
}
