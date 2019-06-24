package test.data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

public class TestDate {

	public static void main(String[] args) throws ParseException {
        System.out.println(System.currentTimeMillis());
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String s= "1553854677";
		Long lg = Long.parseLong(s)*1000;
		Date d = new Date(lg);
		// 1553854677
		LocalDateTime lo =LocalDateTime.now();
		lo.plusSeconds(1553854677);
		//System.out.println(lo.getYear()+"-"+lo.getMonthValue()+"-"+lo.getDayOfMonth()+" "+lo.getHour()+":"+lo.getMinute()+":"+lo.getSecond());
		System.out.println(format.format(d));
		
		System.out.println("___________________________________________________________");
		
		System.out.println("aa:"+format.format(new Date(119,0,1)));
		//2016-08-9T10:01:54.123Z 
		//2019-05-22T09:31:18.000Z
		
		String t = "2019-05-22T09:31:18.000Z";
		SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
		Date d2 = format2.parse(t.replace("Z", " UTC"));
		System.out.println(d2.getTime());
		
		SimpleDateFormat format3 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
		Date curr = new Date();
		System.out.println(format3.format(curr));
		/*
		 *  2017-12-21T08:00:00:00Z
		 *  2019-05-23T14:31:05:00Z
		 */
		
		 SimpleDateFormat f1 = new SimpleDateFormat("yyyyMMddHHmmss");
		 SimpleDateFormat f2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 System.out.println(f2.format(f1.parse("20170120185435")));
		
		
		
	}

}
