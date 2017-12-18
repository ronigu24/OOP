package hw0;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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

		ArrayList<WiFi> array=wifilist.getArray();

		switch(filter){
		case "SSID":{ if (array.get(0).getSSID().toUpperCase().contains(value.toUpperCase()))
			return true;}
		break;
		case "Date": {
			String pattern = "dd/MM/yyyy hh:mm";
			SimpleDateFormat format = new SimpleDateFormat(pattern);
			try {
				Date Start = (Date) format.parse(value.substring(0, value.indexOf(';')));
				Date End = (Date) format.parse(value.substring(value.indexOf(';')+1,value.length() ));
				if (Start.before(wifilist.getTimeStamp())&&End.after(wifilist.getTimeStamp())){
					return true;
				}
			}
			catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;

		}
		case "Distance": {

			LatLng lld1 = new LatLng(wifilist.getPoint().getLat(), wifilist.getPoint().getLon());
			LatLng lld2 = new LatLng(place.getLat(), place.getLon());
			Double distance = lld1.distance(lld2);

			if(this.distance>=distance)
				return true;
			return false;

		}

		}
		return false;
	}
}



