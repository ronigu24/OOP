package test;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

public class DateTest {

	public final static String time1 = "27/10/17 20:00";
	public final static String time2 = "27/10/17 20:00";
	public final static String time3 = "27/10/17 14:00";

	DateFormat Format = new SimpleDateFormat("yy/MM/dd HH:mm");

	@SuppressWarnings("unused")
	@Test
	public void testDateconstructor() throws ParseException {
		Date date1 = (Date) Format.parse(time1);

		if (date1 == null)
			fail("JUnit fail: Somthing is wrong with the Time construction");

	}

	@Test
	public void testCompare() throws ParseException {
		Date date1 = (Date) Format.parse(time1);

		Date date2 = (Date) Format.parse(time2);

		Date date3 = (Date) Format.parse(time3);

		if (!date1.equals(date2))
			fail("JUnit fail: Somthing is wrong with the Time compare");
		if (date2.equals(date3))
			fail("JUnit fail: Somthing is wrong with the Time compare");

	}
}
