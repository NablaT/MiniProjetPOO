package Date;

import java.util.Calendar;

public class Testcalendar {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Calendar c= Calendar.getInstance();
		c.set(2013, 02, 32);
		Calendar c2= Calendar.getInstance();
		c2.set(11, 11, 32, 11, 11);
		System.out.println(c.getTime().toString());
	}
}
