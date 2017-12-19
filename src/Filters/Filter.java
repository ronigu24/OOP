package Filters;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import Objects.Point3D;
import Objects.WiFi;
import Objects.WiFiList;
import uk.me.jstott.jcoord.LatLng;

public class Filter {
	private String filter;
	private String value;
	private Point3D place;
	private double distance;

	public Filter (String filter, String value){
		this.filter = filter;
		this.value = value;
	}
	public Filter (String filter, Point3D place, double distance){
		this.filter = filter;
		this.place=place;
		this.distance=distance;

	}
	public boolean isFit(WiFiList wifilist){

		

		switch(filter){
		
		
		case "SSID":{
			ID_Filter filter=new ID_Filter(value);
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
}



