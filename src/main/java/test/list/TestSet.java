package test.list;

import java.util.ArrayList;
import java.util.List;

public class TestSet {

	public static void main(String[] args) {
		List l = new ArrayList();
		l.add("1");
		l.add("1");
		l.add("1");
       System.out.println(l);
	   System.out.println( String.join(",", l));
	   
	  
	}

}
