package Filters;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import Objects.WiFiList;

public class Time_Filter {

	private String value;
	
	public Time_Filter (String value)
	{
		this.value=value;
	}
	public boolean test(WiFiList wifilist) {
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
}
