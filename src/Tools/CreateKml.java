package Tools;

import java.io.BufferedReader;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import de.micromata.opengis.kml.v_2_2_0.Document;
import de.micromata.opengis.kml.v_2_2_0.Icon;
import de.micromata.opengis.kml.v_2_2_0.IconStyle;
import de.micromata.opengis.kml.v_2_2_0.Kml;
import de.micromata.opengis.kml.v_2_2_0.TimeStamp;

/**
 * @author This class create KML file.
 */

public class CreateKml {

	public static void csvtokml(File csv) throws IOException, ParseException {
		final Kml kml = new Kml();
		Document doc = kml.createAndSetDocument();
		FileReader fr = new FileReader(csv);
		@SuppressWarnings("resource")
		BufferedReader br = new BufferedReader(fr);

		/**
		 * Set icons for power signal
		 */
		// Green Icon//
		IconStyle iconStyle = new IconStyle();
		Icon icon = new Icon();
		icon.setHref("http://maps.google.com/mapfiles/kml/paddle/grn-circle.png");
		iconStyle.setScale(1.0);
		iconStyle.setIcon(icon);
		doc.createAndAddStyle().withId("green").setIconStyle(iconStyle);

		// Yellow Icon//
		Icon iconYellow = new Icon();
		iconYellow.setHref("http://maps.google.com/mapfiles/kml/paddle/ylw-circle.png");
		IconStyle iconStyleYellow = new IconStyle();
		iconStyleYellow.setScale(1.0);
		iconStyleYellow.setIcon(iconYellow);
		doc.createAndAddStyle().withId("yellow").setIconStyle(iconStyleYellow);

		// Red Icon
		Icon iconRed = new Icon();
		iconRed.setHref("http://maps.google.com/mapfiles/kml/paddle/red-circle.png");
		IconStyle iconStyleRed = new IconStyle();
		iconStyleRed.setScale(1.0);
		iconStyleRed.setIcon(iconRed);
		doc.createAndAddStyle().withId("red").setIconStyle(iconStyleRed);

		String str = br.readLine();
		str = br.readLine();
		TimeStamp timestamp = new TimeStamp();
		double lat, lon;
		String signal;
		String ssid;
		int check = 0;
		int numWifi;

		/**
		 @param Copy information from Csv file to Kml file
		 */

		while (str != null) {
			String[] srr = str.split(",");
			timestamp = StringTime(srr[1]);
			lat = Double.parseDouble((srr[2].trim()));
			lon = Double.parseDouble((srr[3].trim()));
			numWifi = Integer.parseInt(srr[5]);
			for (int i = 0; i < numWifi; i++) {
				ssid = srr[6 + check];
				signal = (srr[9 + check]);
				doc.createAndAddPlacemark().withTimePrimitive(timestamp).withName(ssid).withStyleUrl(color(signal))
						.createAndSetPoint().addToCoordinates(lon, lat);
				check += 4;

			}
			check = 0;
			str = br.readLine();

		}
		String KmlFile = "C:\\Users\\Omri Baruch\\Desktop\\CSVFile\\KMLFile\\kmlFile";
		try {
			kml.marshal(new File(KmlFile));
			System.out.println("kml create");

		} catch (Exception e) {

		}

	}

	/**
	 @param This function change syntax for kml file and convert to TimeStamp
	 */
	private static TimeStamp StringTime(String time) {
		TimeStamp timeStamp = new TimeStamp();
		time = time.replace("/", "-");
		String[] Time = time.split(" ");
		time = Time[0] + "T" + Time[1] + "Z";
		timeStamp.setWhen(time);
		return timeStamp;

	}

	/**
	 @param This function get power signal and set icon as per value green<yellow<red
	 */
	private static String color(String signal) {
		int a = Integer.parseInt(signal);
		String b;
		if (a <= -80)
			b = "" + "#green";
		else if (a < -60 && a > -80)
			b = "" + "#yellow";
		else
			b = "" + "#red";
		return b;
	}

}
