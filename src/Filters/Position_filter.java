package Filters;



import Objects.Point3D;

import Objects.WiFiList;
import uk.me.jstott.jcoord.LatLng;

public class Position_filter {

private final Point3D place;
private final double distance;

public Position_filter(Point3D place, double distance) {
	this.place = place;
	this.distance = distance;
}
public boolean test(WiFiList wifilist) {

	LatLng lld1 = new LatLng(wifilist.getPoint().getLat(), wifilist.getPoint().getLon());
	LatLng lld2 = new LatLng(place.getLat(), place.getLon());
	Double distance = lld1.distance(lld2);

	if(this.distance>=distance)
		return true;
	return false;
}



}

