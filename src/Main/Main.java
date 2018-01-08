package Main;

import java.io.File;

import java.io.IOException;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

import Filters.Filter;
import Objects.Point3D;
import Objects.WiFiList;
import Tools.CreateCsv;
import Tools.CreateKml;
import Tools.readcsv;


public class Main {
	public static  ArrayList<WiFiList> Wifilist=new ArrayList<WiFiList>();
	public static  ArrayList<WiFiList> WifilistTemp=new ArrayList<WiFiList>();



public static ArrayList<WiFiList> getWifilistTemp() {
		return WifilistTemp;
	}

	public static void setWifilistTemp(ArrayList<WiFiList> wifilistTemp) {
		WifilistTemp = wifilistTemp;
	}

public static File getFolder() {
		return folder;
	}

	public static void setFolder(File folder) {
		Main.folder = folder;
	}

public static 	File folder = new File("C:\\Users\\"+"RoniGu"+"\\Desktop\\CSVFile");
public static 	File Mainfolder = new File("C:\\Users\\"+"RoniGu"+"\\Desktop\\CSVFile\\BM2");

public static Filter filter;


	public static ArrayList<WiFiList> getWifilist() {
	return Wifilist;
}

public static void setWifilist(ArrayList<WiFiList> wifilist) {
	Wifilist = wifilist;
}

	public static void main(String[] args) throws ParseException, IOException {
		// TODO Auto-generated method stub
		int choice = 0;
		String SSID,username,FileName;
		String start, end;
		Scanner sc = new Scanner(System.in);
		double lat, lon, distance;
		Point3D place = null;
		System.out.println("Please put CsvFile folder on desktop");
		System.out.println("What is your username of your computer?");
		username=sc.next();

		 Wifilist = readcsv.readcsvFolder(Mainfolder);
		CreateCsv.WriterCsv(Wifilist, "InitCsv", Mainfolder);
		

		Filter filter = null;

		System.out.println("please enter what would you like to do: \n  \n  ");
		System.out.println("1.sort by name(SSID)");
		System.out.println("2.sort by Time");
		System.out.println("3.Sort By Distance");
		System.out.println("4.Weighted Center Point by Mac");
		System.out.println("5.Find Gps to No_Gps Csv");
		System.out.println("6.Without filter");

		choice = sc.nextInt();

		sc.nextLine();
		switch (choice) {
		case 1: {
			System.out.println("Enter SSID name (Afikim/Bezeq/Ariel) ");
			SSID = sc.next();
			filter = new Filter("SSID", SSID);
			FileName = "SSID";
			CreateCsv.ArrayByFilter(Wifilist, filter,FileName, folder);
			CreateCsv.make10List(Wifilist,folder);
		}
			break;
		case 2: {
			System.out.println("Enter start time (dd/MM/yyyy hh:mm) ");
			start = sc.nextLine();

			System.out.println("Enter end time (dd/MM/yyyy hh:mm) ");
			end = sc.nextLine();
			filter = new Filter("Date", start + ";" + end);
			FileName = "TimeCSV";
			CreateCsv.ArrayByFilter(Wifilist, filter, FileName,Mainfolder);
			CreateCsv.make10List(Wifilist,Mainfolder);
		}
			break;
		case 3: {
			System.out.println("Enter your lat coordinate");
			lat = sc.nextDouble();

			System.out.println("Enter end lon coordinate ");
			lon = sc.nextDouble();

			System.out.println("Enter distance from your place in km ");
			distance = sc.nextDouble();

			place = new Point3D(lat, lon, 0);
			filter = new Filter("Distance", place, distance);
			FileName = "DistanceCSV";
			CreateCsv.ArrayByFilter(Wifilist, filter,FileName, Mainfolder);
			
			CreateCsv.make10List(Wifilist,Mainfolder);
			break;
		}

		case 4: {
			
			ArrayList<WiFiList> united=new ArrayList<WiFiList>();
			united = readcsv.readcsv_United(Mainfolder+"\\comb\\_comb_all_.csv");
			CreateCsv.WriterCsv((algorithms.algorithm1.algorithm(united)),"algo1",Mainfolder);

		}
			break;

		case 5: {
			Wifilist=CreateCsv.make10List(Wifilist,Mainfolder);
			File folder_No_Gps = new File("C:\\Users\\"+username+"\\Desktop\\CSVFile\\BM2\\No_Gps");
			ArrayList<WiFiList> No_Gps = readcsv.readcsv_NoGps(folder_No_Gps);
			ArrayList<WiFiList> Found_Gps=algorithms.algorithm2.algorithm(Wifilist, No_Gps);
			CreateCsv.WritertoFinalCsv(Found_Gps, folder_No_Gps);
		}
			break;
		case 6: {

			CreateCsv.make10List(Wifilist,Mainfolder);

		}
		}
		sc.close();

		String finalCsv = "C:\\Users\\"+username+"\\Desktop\\CSVFile\\FinalCsv\\FinalCSV.csv";
		File file1 = new File(finalCsv);
		CreateKml.csvtokml(file1);

	}

}
