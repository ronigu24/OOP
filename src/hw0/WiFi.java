package hw0;

import java.util.Date;

  /**
   * Wifi class defines a wifi point, representing a network by SSID,Mac,Channel and Date
   * 
   */


public class WiFi implements Comparable<WiFi> {

	private String SSID,MAC;
	private int channel,signal;
	private Date date;
	
	
	public WiFi(String SSID,String MAC,int channel,int signal,Date date) {
		
		this.SSID = SSID;
		this.MAC = MAC;
		this.channel = channel;
		this.signal = signal;
		this.date = date;
	}
	public WiFi()
	{
		this.SSID = "";
		this.MAC = "";
		this.channel = 0;
		this.signal = 0;
	}

	/**
	   * compare between 2 wifi network by signal
	   * if they equals return 1, else -1;
	   */
	
	@Override
	public int compareTo(WiFi other) {
		if (this.signal == other.signal)
			return 0;
		else if (this.signal < other.signal)
			return 1;
		else
			return -1;
	}
	public String toString(){
		return SSID + "," + MAC + "," + channel + "," + signal;
	}
	public String getSSID() {
		return SSID;
	}
	public void setSSID(String sSID) {
		SSID = sSID;
	}
	public String getMAC() {
		return MAC;
	}
	public void setMAC(String mAC) {
		MAC = mAC;
	}
	public int getChannel() {
		return channel;
	}
	public void setChannel(int channel) {
		this.channel = channel;
	}
	public int getSignal() {
		return signal;
	}
	public void setSignal(int signal) {
		this.signal = signal;
	}
	
}
