package algorithms;
//////

import java.util.ArrayList;

import Objects.Point3D;
import Objects.Router;
import Objects.WiFiList;

public class algorithm1 {



	public static ArrayList<WiFiList> algorithm (ArrayList<WiFiList> CsvFile)
	{
		Router[] routers= new Router[10];
		int counter=1;
		int signal;
		String mac;
		Point3D point;
		Router router;

		for (int i = 0; i < CsvFile.size(); i++) {

			point=(CsvFile.get(i).getPoint());
			mac=CsvFile.get(i).getArray().get(0).getMAC();
			signal=CsvFile.get(i).getArray().get(0).getSignal();
			router=new Router (point,signal);
			routers[counter-1]=router;


			for(int k=i+1;k<CsvFile.size();k++)
			{

				if(CsvFile.get(k).getArray().get(0).getMAC().equals(mac))
				{
					if(counter<10)
					{
						counter++;
						point=(CsvFile.get(k).getPoint());
						signal=CsvFile.get(k).getArray().get(0).getSignal();
						router=new Router (point,signal);
						routers[counter-1]=router;
						CsvFile.remove(k);
					}
				}

			}
////
			for(int l=0;l<counter-1;l++)
			{
				for(int m=l+1;m<counter;m++)
				{

					if(routers[l].getSignal()<routers[m].getSignal())
						Swap(routers[l], routers[m]);
				}
			}
			if(counter>1&&counter<4)
			{
				CsvFile.get(i).setPoint(routers[0].getPoint());
				CsvFile.get(i).getArray().get(0).setSignal(routers[0].getSignal());
			}

			if(counter!=1&&counter>=4)
			{
				Router CenterRouter= WeightedCenterPoint(routers[0], routers[1], routers[2]);
				CsvFile.get(i).setPoint(CenterRouter.getPoint());
				CsvFile.get(i).getArray().get(0).setSignal(CenterRouter.getSignal());
			}			


			counter=1;			
		}

		return CsvFile;
	}


	public static void Swap (Router r1,Router r2)
	{
		Router temp=r1;
		r1=r2;
		r2=temp;


	}

	public static Router WeightedCenterPoint(Router r1,Router r2,Router r3)
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
