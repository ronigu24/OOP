package hw0;

/**
 *	WifiList Class, Holds all the relevant info for each network.
 *  Each WifiList has number of variables: id,date,point3d,and Arraylist of wifi.
 */

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class WiFiList implements Comparable<WiFiList> {
	private static int id = 0;
	private int uid;
	private Date timeStamp;
	private ArrayList<WiFi> array;
	private Point3D point;

	public static void resetID() {
		id = 0;
	}

	public ArrayList<WiFi> getArray() {
		return array;
	}

	public void setArray(ArrayList<WiFi> array) {
		this.array = array;
	}

	public WiFiList(Date timeStamp, Point3D point) {
		this.uid = id++; // Count
		this.timeStamp = timeStamp;
		this.point = point;
		this.array = new ArrayList<WiFi>();

	}
	
	/**
	*private function  create arraylist of wifi,and contain up to 10 
	*best wifi by signal. 
	*/

	private void removeTo10() {
		ArrayList<WiFi> result = new ArrayList<WiFi>();
		for (int i = 0; i < array.size() && i < 10; i++) {
			result.add(array.get(i));
		}
		array = result;
	}

	public void add(WiFi wifi) {
		array.add(wifi);
	}
	/**
	*sort array of wifi by signal
	* 
	*  
	*/
	public void SortSignal() {
		Collections.sort(array);
		removeTo10();
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	
	 /**
	   * this function compare between 2 wifilist by date and point3d.
	   * if they equals return true, else false;
	   */
	public boolean compare(Date timeStamp, Point3D point) {
		return this.timeStamp.compareTo(timeStamp) == 0 && this.point.getLat() == point.getLat()
				&& this.point.getLon() == point.getLon() && this.point.getAlt() == point.getAlt();
	}

	@Override
	public int compareTo(WiFiList other) {
		return this.timeStamp.compareTo(timeStamp);
	}

	public String WifiToString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
		String ans = uid + "," + sdf.format(timeStamp) + "," + point.getLat() + "," + point.getLon() + ","
				+ point.getAlt() + "," + array.get(0).toString();
		return ans;
	}

	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
		String ans = uid + "," + sdf.format(timeStamp) + "," + point.getLat() + "," + point.getLon() + ","
				+ point.getAlt() + "," + array.size() + ",";
		for (int i = 0; i < array.size(); i++) {
			ans += array.get(i);
			if (i != array.size() - 1)
				ans += ",";
		}
		return ans;
	}

	public Point3D getPoint() {
		return point;
	}

	public void setPoint(Point3D point) {
		this.point = point;
	}
}
