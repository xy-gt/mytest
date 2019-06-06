package test.string;

import java.util.StringTokenizer;

public class TestStringTokenizer {

	public static void main(String[] args) {

		String s = "dad|dasd|dafd|daaaad|dacd|dafgd|darrd";
		StringTokenizer stringTokenizer=new StringTokenizer(s, "|");
		int a = 0;
		while (stringTokenizer.hasMoreElements()) {
			a++;
			String str = (String) stringTokenizer.nextElement();
			System.err.println("str"+str);
			
		} 
       System.out.println(a);
	}

}
