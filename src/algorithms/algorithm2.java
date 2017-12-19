package algorithms;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import javax.xml.soap.Node;

import Objects.Point3D;
import Objects.WiFiList;

public class algorithm2 {


	final private static int power=2;
	final private static int norm =10000;
	final private static double sig_diff=0.4;
	final private int min_diff=3;
	final private int no_signal=-120;
	final private int diff_no_sig=100;


	public static ArrayList<WiFiList> algorithm (ArrayList<WiFiList> CsvFile,ArrayList<WiFiList> Csv_No_Gps )
	{


		double [] arr=new double[CsvFile.size()];
		double diffr;
		double weight;
		double signal1;
		double signal2;
		double pi=1;
		double WLat1,WLat2,WLat3,WLon1,WLon2,WLon3,WAlt1,WAlt2,WAlt3;
		double SwLat,SwLon,SwAlt;
		double lat,lon,alt;
		for (int i = 0; i < Csv_No_Gps.size(); i++)
		{
			ArrayList<Point2D> Pi = new ArrayList<Point2D>();	

			for (int j = 0; j < CsvFile.size(); j++)
			{
				if(Csv_No_Gps.get(i).getArray().size()==CsvFile.get(j).getArray().size())
				{
					for (int k = 0; k < Csv_No_Gps.get(i).getArray().size(); k++)
					{
						signal1=Csv_No_Gps.get(i).getArray().get(k).getSignal();
						signal2=CsvFile.get(j).getArray().get(k).getSignal();
						diffr= (signal1-signal2);
						weight= (norm/(Math.pow(diffr, sig_diff)*( Math.pow(signal1, power))));
						pi=pi*weight;
					}
					Point2D p=new Point2D.Double(j, pi);
					Pi.add(p);
				}

			}
			sort(Pi);
			double Sweight=Pi.get(0).getY()*Pi.get(1).getY()*Pi.get(2).getY();
			
			WLat1=Pi.get(0).getY()*CsvFile.get((int) Pi.get(0).getX()).getPoint().getLat();
			WLon1=Pi.get(0).getY()*CsvFile.get((int) Pi.get(0).getX()).getPoint().getLon();
			WAlt1=Pi.get(0).getY()*CsvFile.get((int) Pi.get(0).getX()).getPoint().getAlt();
			WLat2=Pi.get(1).getY()*CsvFile.get((int) Pi.get(0).getX()).getPoint().getLat();
			WLon2=Pi.get(1).getY()*CsvFile.get((int) Pi.get(0).getX()).getPoint().getLon();
			WAlt2=Pi.get(1).getY()*CsvFile.get((int) Pi.get(0).getX()).getPoint().getAlt();
			WLat3=Pi.get(2).getY()*CsvFile.get((int) Pi.get(0).getX()).getPoint().getLat();
			WLon3=Pi.get(2).getY()*CsvFile.get((int) Pi.get(0).getX()).getPoint().getLon();
			WAlt3=Pi.get(2).getY()*CsvFile.get((int) Pi.get(0).getX()).getPoint().getAlt();
			
			SwLat=WLat1+WLat2+WLat3;
			SwLon=WLon1+WLon2+WLon3;
			SwAlt=WAlt1+WAlt2+WAlt3;
			lat=SwLat*Sweight;
			lon=SwLon*Sweight;
			alt=SwAlt*Sweight;
			Point3D point=new Point3D(lat, lon, alt);
			Csv_No_Gps.get(i).setPoint(point);
		}
		return Csv_No_Gps;
	}


	public static void sort(ArrayList<Point2D> Pi)
	{

		for(int i=0;i<Pi.size()-1;i++)
		{
			for(int j=1;j<Pi.size();j++)
			{
				if(Pi.get(j).getY()>Pi.get(i).getY())
				{
					swap(Pi.get(i),Pi.get(j));
				}
			}
		}
	}
	public static void swap(Point2D p1,Point2D p2)
	{
		Point2D temp=new Point2D.Double();
		temp=p1;
		p2=p1;
		p2=temp;
	}
}
