package Filters;




import Objects.Point3D;
import Objects.WiFiList;
import uk.me.jstott.jcoord.LatLng;



public class Filter {
	private String value;
	private Point3D place;
	private double distance;
	private String filter;


	public Filter (String filter, String value){
		this.filter = filter;
		this.value = value;
	}
	public String getFilter() {
		return filter;
	}
	public void setFilter(String filter) {
		this.filter = filter;
	}
	public Filter (String filter, Point3D place, double distance){
		this.filter = filter;
		this.place=place;
		this.distance=distance;

	}
	public boolean isFit(WiFiList wifilist){


		switch(filter){
		
		
		case "SSID":{
			SSID_Filter filter=new SSID_Filter(value);
			filter.test(wifilist);
			}
		break;
		case "Date": {

			Time_Filter filter=new Time_Filter(value);
			filter.test(wifilist);
		}

		case "Distance": {

			Position_filter filter=new Position_filter(place, distance);
			filter.test(wifilist);

		}

		}
		return false;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public Point3D getPlace() {
		return place;
	}
	public void setPlace(Point3D place) {
		this.place = place;
	}
	public double getDistance() {
		return distance;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}
}



