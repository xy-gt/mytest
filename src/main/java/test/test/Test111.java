package test.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;

public class Test111 {

	static class Test1111 {
		static int i = 5;
		static final int j = 5;
		static final int k = new Integer(5);
	}

	public static void main(String[] args) {
		System.out.println("i"+ Test111.Test1111.i);
		System.out.println("j"+ Test111.Test1111.j);
		System.out.println("k"+ Test111.Test1111.k);
     System.out.println("---------------------------------");
     
     Integer[] a = {1,2,3,4};
     System.out.println(Arrays.asList(a).size());
     Arrays.asList(a).stream().forEach(System.out::print);
     System.out.println("---------------------------------");
     
     ArrayList l1 = new ArrayList();
     l1.add("l1");
     Vector v1 = new Vector();
     v1.add("l1");
     System.out.println(l1.equals(v1));
    		 
     
     
	}

}
