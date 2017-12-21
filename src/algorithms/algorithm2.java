package algorithms;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import javax.xml.soap.Node;

import Objects.Point3D;
import Objects.WiFiList;
import Tools.CreateCsv;

public class algorithm2 {


	final private static double power=2;
	final private static double norm =10000;
	final private static double sig_diff=0.4;
	//final private int min_diff=3;
	//final private int no_signal=-120;
	final private static double diff_no_sig=100;


	public static ArrayList<WiFiList> algorithm (ArrayList<WiFiList> CsvFile,ArrayList<WiFiList> Csv_No_Gps )
	{

		double diffr,weight;
		double Finalweight=0;;
		double signal1 = 0;
		double signal2=0;
		String mac1,mac2;
		double pi=1;
		double WLat1,WLat2,WLat3,WLon1,WLon2,WLon3,WAlt1,WAlt2,WAlt3;
		double SwLat,SwLon,SwAlt,lat,lon,alt;

		for (int i = 0; i < Csv_No_Gps.size(); i++)
		{

			ArrayList<Point2D> Pi = new ArrayList<Point2D>();	

			for (int j = 0; j < CsvFile.size(); j++)
			{

				for (int k = 0; k < Csv_No_Gps.get(i).getArray().size(); k++)
				{
					mac1=Csv_No_Gps.get(i).getArray().get(k).getMAC();

					for(int l=0;l<CsvFile.get(j).getArray().size();l++)
					{
						mac2=CsvFile.get(j).getArray().get(l).getMAC();

						signal1=Csv_No_Gps.get(i).getArray().get(k).getSignal();
						if(mac1.equals(mac2))
						{

							signal2=CsvFile.get(j).getArray().get(l).getSignal();
							diffr= Math.abs(signal1-signal2);
							double part1=(Math.pow(diffr, sig_diff));
							double part2=( Math.pow(signal1, power));
							double part3=part1*part2;
							weight= ((norm)/(part3));

						}
						else 
						{
							double part1=(Math.pow(diff_no_sig, sig_diff));
							double part2=( Math.pow(signal1, power));
							double part3=part1*part2;
							weight= ((norm)/(part3));

						}
						if(weight>Finalweight)
						{
							Finalweight=weight;
						}

					}

				}
				pi=pi*Finalweight;

				Point2D p=new Point2D.Double(j, pi);

				Pi.add(j,p);




			}
			Finalweight=0;
			pi=1;
			sort(Pi);
			double Sweight=Pi.get(0).getY()+Pi.get(1).getY()+Pi.get(2).getY();
			int line=(int) (Pi.get(0).getX());

			WLat1=Pi.get(0).getY()*CsvFile.get(line).getPoint().getLat();
			WLon1=Pi.get(0).getY()*CsvFile.get(line).getPoint().getLon();
			WAlt1=Pi.get(0).getY()*CsvFile.get(line).getPoint().getAlt();
			WLat2=Pi.get(1).getY()*CsvFile.get(line).getPoint().getLat();
			WLon2=Pi.get(1).getY()*CsvFile.get(line).getPoint().getLon();
			WAlt2=Pi.get(1).getY()*CsvFile.get(line).getPoint().getAlt();
			WLat3=Pi.get(8).getY()*CsvFile.get(line).getPoint().getLat();
			WLon3=Pi.get(8).getY()*CsvFile.get(line).getPoint().getLon();
			WAlt3=Pi.get(8).getY()*CsvFile.get(line).getPoint().getAlt();

			SwLat=WLat1+WLat2+WLat3;
			SwLon=WLon1+WLon2+WLon3;
			SwAlt=WAlt1+WAlt2+WAlt3;
			lat=(SwLat)/(Sweight);
			lon=(SwLon)/(Sweight);
			alt=(SwAlt)/(Sweight);

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
		Point2D temp=new Point2D.Double(0, 0);
		temp=p1;
		p1=p2;
		p2=temp;
	}
}
