package test.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
	}

}
