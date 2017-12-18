package hw0;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

/**
* This class write Csv file
*/


public class writerCsv {

	/**
	* This function gets arrayList<wifiList> and create new united CSV.
	*/

	
	public static void WriterCsv(ArrayList<WiFiList> CsvFile, String name) {
		StringBuilder builder = new StringBuilder();
		PrintWriter pw = null;
		try {
			String finalCsv = "C:\\Users\\RoniGu\\Desktop\\CSVFile\\OneCsv\\" + name + ".csv";
			pw = new PrintWriter(new File(finalCsv));
			builder.append("Id,Time,Lat,Lon,Alt,SSID,MAC,Channel,Signal");
			builder.append("\n");
			for (int i = 0; i < CsvFile.size(); i++) {

				if (CsvFile.get(i) != null) {
					builder.append(CsvFile.get(i).WifiToString() + "\n");
				}
			}
			pw.write(builder.toString());
			pw.close();
			System.out.println("Done  ");
		} catch (

		FileNotFoundException e) {
			e.printStackTrace();

		}
	}

	/**
	* This function gets arrayList<wifiList>, and unite wifi's that have the same date and cordination
	* to arraylist of wifi.
	* go to Write function to create CSV.
	* 
	*  
	*/
	
	public static void make10List(ArrayList<WiFiList> One_Csv_File) {
		ArrayList<WiFiList> result = new ArrayList<WiFiList>();
		WiFiList.resetID();
		WiFiList wifilist = null;
		Date TimeDate = null;
		double lat, lon, alt;
		String mac, ssid;
		Point3D point = null;
		int signal, channel;

		for (int i = 1; i < One_Csv_File.size(); i++) {
			TimeDate = One_Csv_File.get(i).getTimeStamp();
			lat = One_Csv_File.get(i).getPoint().getLat();
			lon = One_Csv_File.get(i).getPoint().getLon();
			alt = One_Csv_File.get(i).getPoint().getAlt();
			point = new Point3D(lat, lon, alt);
			ssid = One_Csv_File.get(i).getArray().get(0).getSSID();
			mac = One_Csv_File.get(i).getArray().get(0).getMAC();
			channel = One_Csv_File.get(i).getArray().get(0).getChannel();
			signal = One_Csv_File.get(i).getArray().get(0).getSignal();
			WiFi newwifi = new WiFi(ssid, mac, channel, signal, TimeDate);
			if (result.size() == 0) {
				wifilist = new WiFiList(TimeDate, point);
				result.add(wifilist);

			} else

			if (!wifilist.compare(TimeDate, point)) {
				wifilist.SortSignal();
				wifilist = new WiFiList(TimeDate, point);
				result.add(wifilist);
			}
			wifilist.add(newwifi);
		}
		Collections.sort(result);
		WritertoFinalCsv(result);

	}
	
	/**
	*  get filter ,file name and arrayList<wifiList>, and create new CSV who filtered by this filter.
	* the file name will be the name of the Csv file. 
	*/

	public static void WriteByFilter(ArrayList<WiFiList> One_Csv_File, Filter filter, String FileName) {

		for (int i = 0; i < One_Csv_File.size(); i++) {
			if (false == filter.isFit(One_Csv_File.get(i)) && One_Csv_File.get(i) != null) {

				One_Csv_File.remove(i);
				i--;

			}

		}
		writerCsv.WriterCsv(One_Csv_File, FileName);

	}

	/**
	*  get arrayList<wifiList>, and create new CSV.
	* the new csv will represent wifi networks
	*  that united to same line if they have same date and cordinations. 
	*/
	
	private static void WritertoFinalCsv(ArrayList<WiFiList> CsvFile) {
		StringBuilder builder = new StringBuilder();
		PrintWriter pw = null;
		try {
			String finalCsv = "C:\\Users\\RoniGu\\Desktop\\CSVFile\\FinalCsv\\FinalCSV.csv";
			pw = new PrintWriter(new File(finalCsv));
			builder.append(
					"Id,Time,Lat,Lon,Alt,#WiFi,SSID1,MAC1,Channel1,Signal1,SSID2,MAC2,Channel2,Signal2,SSID3,MAC3,Channel3,Signal3,SSID4,MAC4,Channel4,Signal4,SSID5,MAC5,Channel5,Signal5,SSID6,MAC6,Channel6,Signal6,SSID7,MAC7,Channel7,Signal7,SSID8,MAC8,Channel8,Signal8,SSID9,MAC9,Channel9,Signal9,SSID10,MAC10,Channel10,Signal10");
			builder.append("\n");
			for (int i = 0; i < CsvFile.size(); i++) {

				builder.append(CsvFile.get(i) + "\n");
			}
			pw.write(builder.toString());
			pw.close();
			System.out.println("Done ");
		} catch (

		FileNotFoundException e) {
			e.printStackTrace();

		}
	}
	
	private static void WriterByMac(ArrayList<WiFiList> CsvFile) {
		
		
		
	}
	
}
