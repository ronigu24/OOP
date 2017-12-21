package Tools;

/**
 *readcsv class read from Csv files
 *  
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

import Objects.Point3D;
import Objects.WiFi;
import Objects.WiFiList;


/**
 @author This function gets folder file. from this folder take only files with Csv suffix,
   read them and creates ArrayList<WiFiList>.
   this ArrayList contains: id,date,point3d,and Arraylist of wifi.

 * 
 *  
 */

public class readcsv {

	public static ArrayList<WiFiList> readcsvFolder(File Folder) throws ParseException {
		ArrayList<WiFiList> AllWifi = new ArrayList<WiFiList>();
		String Str;
		String FileName = Folder.toString();
		String[] names = Folder.list();
		Date TimeDate = null;
		double lat, lon, alt;
		String ssid, mac;
		int signal,channel;

		try {
			String[] Line;

			for (int i = 0; i < names.length; i++) {
				if (names[i].contains(".csv")) {
					FileReader fr = new FileReader(FileName + "\\" + names[i]);
					BufferedReader br = new BufferedReader(fr);

					Str = br.readLine();
					Str = br.readLine();
					Str = br.readLine();

					while (Str != null) {

						Line = Str.split(",");
						lat = Double.parseDouble(Line[6]);
						lon = Double.parseDouble(Line[7]);
						alt = Double.parseDouble(Line[8]);

						Point3D point=new Point3D(lat,lon,alt);

						if (Line[3].contains("/")) {
							TimeDate = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").parse(Line[3]);

						} else {
							TimeDate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(Line[3]);
						}
						ssid=Line[1];
						mac=Line[0];
						channel=Integer.parseInt(Line[4]);
						signal =Integer.parseInt(Line[5]);

						WiFi wifi = new WiFi(ssid,mac,channel,signal,TimeDate);
						WiFiList wifilist = new WiFiList(TimeDate, point);

						Str = br.readLine();
						wifilist.add(wifi);
						AllWifi.add(wifilist);
						Collections.sort(AllWifi);
					}


					br.close();
					fr.close();
					Collections.sort(AllWifi);
				}
			}
		} catch (IOException ex) {
			System.out.print("Error reading file\n" + ex);

		}
		return AllWifi;
	}




	public static ArrayList<WiFiList> readcsv_NoGps(File Folder) throws ParseException {
		ArrayList<WiFiList> AllWifi = new ArrayList<WiFiList>();
		String Str;
		String FileName = Folder.toString();
		String[] names = Folder.list();
		Date TimeDate = null;
		double lat, lon, alt;
		String ssid, mac;
		int signal,channel;
		int place=0;
		try {
			String[] Line;

			for (int i = 0; i < names.length; i++) {
				if (names[i].contains(".csv")) {
					FileReader fr = new FileReader(FileName + "\\" + names[i]);
					BufferedReader br = new BufferedReader(fr);

					Str = br.readLine();

					while (Str != null) {

						Line = Str.split(",");
						lat =0;
						lon =0;
						alt =0;

						Point3D point=new Point3D(lat,lon,alt);
						String date=Line[0].substring(0,14);
						if (Line[0].contains("/")) {
							
							TimeDate = new SimpleDateFormat("dd/MM/yyyy hh:mm").parse(date);

						} else {
							TimeDate = new SimpleDateFormat("yyyy-MM-dd hh:mm").parse(date);
						}
						WiFiList wifilist = new WiFiList(TimeDate, point);

						while(place+6<Line.length)
						{
							
							ssid=Line[place+6];
							mac=Line[place+7];
							channel=Integer.parseInt(Line[place+8]);
							signal =Integer.parseInt(Line[place+9]);

							WiFi wifi = new WiFi(ssid,mac,channel,signal,TimeDate);

							wifilist.add(wifi);
							 place=place+4;
							 //System.out.println(wifilist.getArray().size());
						}
						place=0;
						AllWifi.add(wifilist);
						Collections.sort(AllWifi);
						Str = br.readLine();
					}


					br.close();
					fr.close();
					Collections.sort(AllWifi);
				}
			}
		} catch (IOException ex) {
			System.out.print("Error reading file\n" + ex);

		}
		return AllWifi;
	}

}

