package Objects;

/**
* The Point2D class defines a point representing a location in (lat,lon,alt) coordinate space.
*/

public class Point3D {

	private double Lat;
	private double Lon;
	private double Alt;
	
	public Point3D(double lat,double lon,double alt)
	{
		this.Lat=lat;
		this.Lon=lon;
		this.Alt=alt;
	}

	public double getLat() {
		return Lat;
	}

	public void setLat(double lat) {
		Lat = lat;
	}

	public double getLon() {
		return Lon;
	}

	public void setLon(double lon) {
		Lon = lon;
	}

	public double getAlt() {
		return Alt;
	}

	public void setAlt(double alt) {
		Alt = alt;
	}

	public boolean compare(Point3D p2) {
		// TODO Auto-generated method stub
		return false;
	}
	

}
