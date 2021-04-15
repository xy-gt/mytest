package test.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestLong {

	public static void main(String[] args) {
		System.out.println(Long.bitCount(10));
		System.err.println(Long.parseLong("101"));

		String s = "1001,1002";
		
		System.out.println(Arrays.asList(s));
		
		List<String> a = new ArrayList();
		a.add("1".toString());
		a.add("3".toString());
		System.out.println(a);

		Pattern pattern = Pattern.compile("[0-9]*");
		Matcher isNum = pattern.matcher("223afaf".charAt(0)+"");
		if (isNum.matches()) {
			System.out.println("sss");
		}else
		System.out.println("fffffffff");

	}

}
