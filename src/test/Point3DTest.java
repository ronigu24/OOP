package test;


	
	import static org.junit.Assert.*;
	import org.junit.Test;

	
import hw0.Point3D;

	public class Point3DTest {
		
		public static final double alt1 = 39.01806582;
		public static final double lon1 = 34.80988156;
		public static final double lat1 = 32.16766122;
		
		public static final double alt2 = 39.01806582;
		public static final double lon2 = 34.80988156;
		public static final double lat2 = 32.16766122;
		
		public static final double alt3 = 30.01806580;
		public static final double lon3 = 30.80934150;
		public static final double lat3 = 32.67536120;
		
		@SuppressWarnings("unused")
		@Test
		public void testPoint3Dconstructor() {
			Point3D p=new Point3D(alt1,lon1,lat1);
			if(p==null) fail("JUnit fail: Somthing is wrong with the Position construction");
		}
		
		@Test
		public void testCompare(){
			Point3D p1=new Point3D(alt1,lon1,lat1);
			Point3D p2=new Point3D(alt2,lon2,lat2);
			Point3D p3=new Point3D(alt3,lon3,lat3);
			if(!p1.compare(p2)) fail("JUnit fail: Somthing is wrong with the Position compare");
			if(p1.compare(p3)) fail("JUnit fail: Somthing is wrong with the Position compare");
		}
		
	}


