package Filters;

import java.util.ArrayList;

import Objects.WiFi;
import Objects.WiFiList;

public class SSID_Filter {

	private String value;
	
	public  SSID_Filter(String value)
	{
		this.value=value;
	}
	public boolean test(WiFiList wifilist) {
		
		ArrayList<WiFi> array=wifilist.getArray();
	if (array.get(0).getSSID().toUpperCase().contains(value.toUpperCase()))
		return true;
	return false;
	}
}
