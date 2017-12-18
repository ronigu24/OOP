package test;


import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import hw0.WiFi;



public class WifiTest {
		
	public final static String ssid = "Bezeq";
	public final static String mac = "6a:12:f5:f9:5e:71";
	public final static int signal = -60;
	public final static int channel = 10;
	public final static Date date=null;
	
	@SuppressWarnings("unused")
	@Test
	public void testWificonstructor(){
	WiFi new_Wifi = new WiFi( ssid, ssid, channel, signal,date );
	if (new_Wifi == null) {
			fail("JUnit fail: Somthing is wrong with the Wifi construction");
		}	
	}		
}