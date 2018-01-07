package algorithms;

import java.sql.Date;
import java.util.ArrayList;
import Objects.Point3D;
import Objects.Router;
import Objects.WiFi;
import Objects.WiFiList;

public class algorithm1 {



	public static ArrayList<WiFiList> algorithm (ArrayList<WiFiList> CsvFile1)
	{
		ArrayList<WiFiList> arr=new ArrayList<WiFiList> (CsvFile1);
		ArrayList<WiFiList> algo1=new ArrayList<WiFiList>();
		int place=0;
		Router[] routers= new Router[10];
		int counter=1;
		int signal, channel,signal1 = 0;
		String mac;
		Point3D point;
		Router router;
		String SSID;
		Point3D point1 = null;
		java.util.Date date;

		for (int i = 0; arr.get(i)!=null&&i<arr.size()-2; i++) {

			for (int j = 0; j < arr.get(i).getArray().size(); j++) {


				point=(arr.get(i).getPoint());
				mac=arr.get(i).getArray().get(j).getMAC();
				signal=arr.get(i).getArray().get(j).getSignal();
				router=new Router (point,signal);
				routers[counter-1]=router;
				SSID=arr.get(i).getArray().get(j).getSSID();
				date=arr.get(i).getTimeStamp();
				channel=arr.get(i).getArray().get(j).getChannel();

				for(int k=i+1;arr.get(k)!=null&&k<arr.size()-2;k++)
				{
					for (int l = 0; l < arr.get(k).getArray().size(); l++) {



						if(arr.get(k).getArray().get(l).getMAC().equals(mac))
						{
							if(counter<10)
							{
								counter++;
								point=(arr.get(k).getPoint());
								signal=arr.get(k).getArray().get(l).getSignal();
								router=new Router (point,signal);
								routers[counter-1]=router;
								//arr.get(k).getArray().remove(l);
							}
							arr.get(k).getArray().remove(l);

						}
						if(arr.get(k).getArray().isEmpty())
							arr.remove(k);
					}
				}


				for(int l=0;l<counter-1;l++)
				{
					for(int m=l+1;m<counter;m++)
					{

						if(routers[l].getSignal()<routers[m].getSignal())
							Swap(routers[l], routers[m]);
					}
				}
				if(counter>=1&&counter<3)
				{
					 point1 =routers[0].getPoint();
					 signal1=routers[0].getSignal();
					
				}

				else if(counter>=3)
				{
					Router CenterRouter= WeightedCenterPoint(routers[0], routers[1], routers[2]);
					 point1 =CenterRouter.getPoint();
					 signal1=CenterRouter.getSignal();
				
				}			

				
				WiFi wifi = new WiFi(SSID,mac,channel,signal1,date);
				WiFiList wifilist = new WiFiList(date, point1);

				wifilist.add(wifi);
				algo1.add(wifilist);
				place++;
				counter=1;			
			}
		}
		return algo1;
	}


	private static void Swap (Router r1,Router r2)
	{
		Router temp=r1;
		r1=r2;
		r2=temp;


	}

	private static Router WeightedCenterPoint(Router r1,Router r2,Router r3)
	{
		double weightr1, weightr2, weightr3, wLat1, wLon1, wAlt1, wLat2, wLon2, wAlt2, wLat3, wLon3, wAlt3;
		double sumLat,sumLon,sumAlt,sumWeight;
		Router CenterRouter;
		Point3D point;

		weightr1=1/(Math.pow(r1.getSignal(), 2));
		weightr2=1/(Math.pow(r2.getSignal(), 2));
		weightr3=1/(Math.pow(r3.getSignal(), 2));
		wLat1=weightr1*r1.getPoint().getLat();
		wLon1=weightr1*r1.getPoint().getLon();
		wAlt1=weightr1*r1.getPoint().getAlt();
		wLat2=weightr2*r2.getPoint().getLat();
		wLon2=weightr2*r2.getPoint().getLon();
		wAlt2=weightr2*r2.getPoint().getAlt();
		wLat3=weightr3*r3.getPoint().getLat();
		wLon3=weightr3*r3.getPoint().getLon();
		wAlt3=weightr3*r3.getPoint().getAlt();
		sumLat= wLat1+wLat2+wLat3;
		sumLon= wLon1+wLon2+wLon3;
		sumAlt= wAlt1+wAlt2+wAlt3;
		sumWeight=weightr1+weightr2+weightr3;
		point=new Point3D(sumLat/sumWeight,sumLon/sumWeight,sumAlt/sumWeight);

		CenterRouter=new Router (point,r1.getSignal());

		return CenterRouter;
	}


}
