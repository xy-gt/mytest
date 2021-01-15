package test.testdate;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

public class TestDate {

	public static void main(String[] args) throws ParseException, InterruptedException {
		Date d = new Date();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String s = df.format(d);
		System.out.println(s);
		
	  
		Date d2 = new Date();
		System.out.println(d2.getTime());
	    System.out.println(d2.toString());
		System.out.println(d2.after(d));
		
		System.out.println("sss:"+df.format(new Date(1559096687406L)));
		System.out.println("sss2:"+df.format(new Date(1559096657625L)));
		
		System.out.println("--"+ (1557728992384L-1557721514752L));


		LocalDateTime localDateTime = LocalDateTime.now();
		System.out.println(localDateTime);

		System.out.println(localDateTime.plusDays(-1));
		System.out.println(localDateTime.plusHours(-1));

	}

}
